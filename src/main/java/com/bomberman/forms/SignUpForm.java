package com.bomberman.forms;

import javax.servlet.http.HttpServletRequest;

import com.bomberman.beans.User;
import com.bomberman.dao.UserDao;

public class SignUpForm {

		private boolean isOk;
		
		public SignUpForm() {
			this.isOk = false;
		}
		
		public User verifyData(HttpServletRequest req, UserDao userDao) {
			
			String pseudo = req.getParameter("pseudo");
			String login = req.getParameter("login");
			String password = req.getParameter("password");
			
			User user = new User();
			
			user.setLogin(login);
			user.setPassword(password);
			user.setPseudo(pseudo);
			
			userDao.ajouter(user);
			
			return user;
		}
}
