package com.bomberman.api;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bomberman.forms.GameWonForm;
import com.bomberman.forms.ServerForm;

/**
 * Servlet implementation class APIGameWon
 */
@WebServlet("/APIGameWon")
public class APIGameWon extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public APIGameWon() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		GameWonForm gameWonForm = new GameWonForm();

		boolean isOk = gameWonForm.verifyServer(request);

		if(isOk) {
			System.out.println("GameWon added");;
		}
	}

}
