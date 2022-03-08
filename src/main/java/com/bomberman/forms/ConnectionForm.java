package com.bomberman.forms;

import javax.servlet.http.HttpServletRequest;

import com.bomberman.beans.User;
import com.bomberman.dao.DaoFactory;
import com.bomberman.dao.UserDao;
import com.bomberman.security.Hashing;

public class ConnectionForm {
	private String res;
	private boolean isOk;
	private User user;
	
	public ConnectionForm() {
		this.isOk = false;
	}
	
	public User verifyId(HttpServletRequest req) {
		String login = req.getParameter("login");
		String password = req.getParameter("password");
		
		User user = new User();
		
		user.setLogin(login);
		user.setPassword(Hashing.hash(password));
		
		DaoFactory daoFactory = DaoFactory.getInstance();
		UserDao userDao = daoFactory.getUserDao();
		
		if(userDao.connect(user)) {
			return userDao.getInfo(user);
		} else {
			return null;
		}
		
	}

	public boolean isOk() {
		return isOk;
	}

	public void setOk(boolean isOk) {
		this.isOk = isOk;
	}

	public String getRes() {
		return res;
	}

	public void setRes(String res) {
		this.res = res;
	}
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	

}
