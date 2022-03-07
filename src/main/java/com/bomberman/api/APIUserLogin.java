package com.bomberman.api;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bomberman.beans.User;
import com.bomberman.forms.ConnectionForm;

@WebServlet("/APIUserLogin")
public class APIUserLogin extends HttpServlet{
	
	private static final long serialVersionUID = 1;
	
	public APIUserLogin() {
		super();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter output = new PrintWriter(response.getOutputStream(), true);
		
		if(!request.getParameter("token").equals("5634964c-5cf4-4c68-a5b7-745955e873ea")) {
			output.println("null");
			return;
		}
		
		ConnectionForm connectionForm = new ConnectionForm();
		User user = connectionForm.verifyId(request);
	
		
		if(user != null) {
			output.println(user.getId());
		} else {
			output.println("null");
		}
	}
}
