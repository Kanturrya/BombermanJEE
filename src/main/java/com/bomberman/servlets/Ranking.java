package com.bomberman.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bomberman.dao.DaoFactory;
import com.bomberman.dao.RankingDao;

/**
 * Servlet implementation class Ranking
 */
@WebServlet("/Ranking")
public class Ranking extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RankingDao rankingDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ranking() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init() throws ServletException{
    	DaoFactory daoFactory = DaoFactory.getInstance();
    	this.rankingDao = daoFactory.getRankingDao();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("rank", rankingDao.getRanking());
		this.getServletContext().getRequestDispatcher("/WEB-INF/classement.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
