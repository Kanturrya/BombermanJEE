package com.bomberman.api;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bomberman.beans.User;
import com.bomberman.forms.ConnectionForm;

public class APIUserLogin extends HttpServlet{
	
	private static final long serialVersionUID = 1;
	
	public APIUserLogin() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ConnectionForm connectionForm = new ConnectionForm();
		
		User user = connectionForm.verifyId(request);
		
		PrintWriter outpout = new PrintWriter(response.getOutputStream(), true);
		
		if(user != null) {
			outpout.println(user.getId());
		}
	}
}
