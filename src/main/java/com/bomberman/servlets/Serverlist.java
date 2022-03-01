package com.bomberman.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bomberman.dao.DaoFactory;
import com.bomberman.dao.ServerDao;

/**
 * Servlet implementation class ListeServeur
 */
@WebServlet("/Serverlist")
public class Serverlist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private ServerDao serverDao;
    
    public Serverlist() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init() throws ServletException{
    	DaoFactory daoFactory = DaoFactory.getInstance();
    	this.serverDao = daoFactory.getServerDao();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("servers", serverDao.getServerlist());
		this.getServletContext().getRequestDispatcher("/WEB-INF/serverlist.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
