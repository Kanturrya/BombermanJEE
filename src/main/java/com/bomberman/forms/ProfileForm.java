package com.bomberman.forms;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.bomberman.beans.User;
import com.bomberman.dao.DaoFactory;
import com.bomberman.dao.UserDao;
import com.bomberman.security.Hashing;

public class ProfileForm {
	public void updateProfile(HttpServletRequest req) {
		HttpSession session = req.getSession();
		
		User user = ((User) session.getAttribute("user"));
		
		String pseudo = req.getParameter("pseudo");
		String new_password = req.getParameter("new_password");
		String cur_password = req.getParameter("cur_password");
		
		if(cur_password.isEmpty() || !Hashing.check(user.getPassword(), cur_password)) {
			req.setAttribute("status1", "Votre mot de passe actuel est incorrect!");
			return;
		}
		
		DaoFactory daoFactory = DaoFactory.getInstance();
		UserDao userDao = daoFactory.getUserDao();
		
		int id = user.getId();
		
		if(!pseudo.isEmpty()) {
			if(userDao.changePseudo(id, pseudo)) {
				user.setPseudo(pseudo);
				req.setAttribute("status1", "Votre pseudo a bien été changé!");
			} else {
				req.setAttribute("status1", "Votre pseudo n'a pas pu être changé.");
			}
		}
		
		if(!new_password.isEmpty()) {
			new_password = Hashing.hash(new_password);
			if(userDao.changePassword(id, new_password)) {
				user.setPassword(new_password);
				req.setAttribute("status2", "Votre mot de passe a bien été changé!");
			} else {
				req.setAttribute("status2", "Votre mot de passe n'a pas pu être changé.");
			}
		}
		
		session.setAttribute("user", user);
	}
}
