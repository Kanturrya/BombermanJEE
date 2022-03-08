package com.bomberman.api;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bomberman.forms.GameForm;

@WebServlet("/APIGame")
public class APIGame extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public APIGame() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GameForm gameForm = new GameForm();
	
		int id = gameForm.addGame(request);
		PrintWriter output = new PrintWriter(response.getOutputStream(), true);
		
		if(id !=  0) {
			output.println(id);
		}
	}

}
