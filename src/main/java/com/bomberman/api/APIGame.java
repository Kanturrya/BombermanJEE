package com.bomberman.api;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bomberman.dao.DaoFactory;
import com.bomberman.dao.GameDao;

@WebServlet("/APIGame")
public class APIGame extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public APIGame() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect(request.getContextPath() + "/index");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoFactory daoFactory = DaoFactory.getInstance();
		GameDao gameDao = daoFactory.getGameDao();
		
		if(request.getParameter("token").equals("2028e275-7757-44f9-893a-d1990153c6c7")) {
			int id = gameDao.addGame(request.getParameter("map"));
		
			PrintWriter output = new PrintWriter(response.getOutputStream(), true);
			
			if(id != 0) {
				output.println(id);
			}
		}
	}

}
