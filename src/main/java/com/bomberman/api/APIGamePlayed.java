package com.bomberman.api;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bomberman.forms.GamePlayedForm;


@WebServlet("/APIGamePlayed")
public class APIGamePlayed extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public APIGamePlayed() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GamePlayedForm gamePlayedForm = new GamePlayedForm();
		gamePlayedForm.verifyServer(request);
	}

}
