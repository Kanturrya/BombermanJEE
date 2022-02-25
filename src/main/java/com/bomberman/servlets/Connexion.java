package com.bomberman.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bomberman.beans.User;
import com.bomberman.dao.DaoFactory;
import com.bomberman.dao.UserDao;
import com.bomberman.forms.ConnectionForm;


@WebServlet("/Connexion")
public class Connexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserDao userDao;

    public Connexion() {
        super();
    }
    
    public void init() throws ServletException{
    	DaoFactory daoFactory = DaoFactory.getInstance();
    	this.userDao = daoFactory.getUserDao();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/connexion.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ConnectionForm form = new ConnectionForm();
		
		User user = form.verifyId(request, userDao);
			
		if(user == null) {
			HttpSession session = request.getSession();
			request.setAttribute("status", "Connexion échouée!");
			request.setAttribute("user", user);		
			this.getServletContext().getRequestDispatcher("/WEB-INF/connexion.jsp").forward(request, response);
		} else {
			HttpSession session = request.getSession();
            session.setAttribute("user", user);
			this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
		}
		
	}

}
