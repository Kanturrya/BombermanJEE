package com.bomberman.forms;

import java.security.SecureRandom;
import java.security.spec.KeySpec;
import java.util.Base64;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.servlet.http.HttpServletRequest;

import com.bomberman.beans.User;
import com.bomberman.dao.UserDao;

public class ConnectionForm {
	
	private String res;
	private boolean isOk;
	private User user;
	

	public ConnectionForm() {
		this.isOk = false;
	}
	
	public User verifyId(HttpServletRequest req, UserDao userDao) {
		
		String login = req.getParameter("login");
		String password = req.getParameter("password");
		
		checkPass(password);
		User user = new User();
		
		user.setLogin(login);
		user.setPassword(password);
		
		if(userDao.connexion(user)) {
			return userDao.getInfo(user);
		} else {
			return null;
		}
		
	}
	
	private void checkPass(String pass) {
		SecureRandom random = new SecureRandom();
		byte[] salt = new byte[16];
		random.nextBytes(salt);
		
		KeySpec spec = new PBEKeySpec(pass.toCharArray(), salt, 65536, 128);
		try {
			SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
			byte[] hash = factory.generateSecret(spec).getEncoded();
			Base64.Encoder enc = Base64.getEncoder();
			System.out.printf("salt: %s%n", enc.encodeToString(salt));
			System.out.printf("hash: %s%n", enc.encodeToString(hash));
		} catch (Exception e) {
			e.printStackTrace();
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
