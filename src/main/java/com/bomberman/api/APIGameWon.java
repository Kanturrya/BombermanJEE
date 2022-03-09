package com.bomberman.api;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bomberman.dao.DaoFactory;
import com.bomberman.dao.GameWonDao;

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
		if(request.getParameter("userid") == null || request.getParameter("gameid") == null || !request.getParameter("token").equals("c479631b-e171-4cdc-bad0-e60b7c98b281")) {
			return;
		}
		
		DaoFactory daoFactory = DaoFactory.getInstance();
		GameWonDao gameWonDao = daoFactory.getGameWonDao();
		gameWonDao.addGameWon(Integer.parseInt(request.getParameter("userid")), Integer.parseInt(request.getParameter("gameid")));
	}

}
