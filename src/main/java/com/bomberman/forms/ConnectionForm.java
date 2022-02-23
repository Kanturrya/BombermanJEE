package com.bomberman.forms;

import javax.servlet.http.HttpServletRequest;

public class ConnectionForm {
	
	private String res;
	private boolean isOk;
	
	public ConnectionForm() {
		this.isOk = false;
	}
	
	public void verifyId(HttpServletRequest req) {
		
		String login = req.getParameter("login");
		String password = req.getParameter("password");
		
		//Pour tester ça va changer
		
		if(password.equals("aze")) {
			res = "Connexion ok !";
			isOk = true;
		} else {
			res = "Connexion échouée, identifiants incorrects !";
			isOk = false;
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
	

}
