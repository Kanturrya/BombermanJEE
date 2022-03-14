package com.bomberman.api;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bomberman.dao.DaoFactory;
import com.bomberman.dao.GamePlayedDao;


@WebServlet("/APIGamePlayed")
public class APIGamePlayed extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public APIGamePlayed() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.sendRedirect(request.getContextPath() + "/index");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("userid") == null || request.getParameter("gameid") == null || !request.getParameter("token").equals("132913b9-6b2e-44e0-8265-3562299e1518")) {
			return;
		}
		
		DaoFactory daoFactory = DaoFactory.getInstance();
		GamePlayedDao gamePlayedDao = daoFactory.getGamePlayedDao();
		gamePlayedDao.addGamePlayed(Integer.parseInt(request.getParameter("userid")), Integer.parseInt(request.getParameter("gameid")));
	}

}
