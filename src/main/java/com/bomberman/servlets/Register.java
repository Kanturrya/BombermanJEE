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
import com.bomberman.forms.SignUpForm;

/**
 * Servlet implementation class SignUp
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userDao;
	
	public void init() throws ServletException{
    	DaoFactory daoFactory = DaoFactory.getInstance();
    	this.userDao = daoFactory.getUserDao();
    }
       
    public Register() {
        super();
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/signup.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SignUpForm signupform = new SignUpForm();
		
		User user = signupform.verifyData(request, userDao);
		
		HttpSession session = request.getSession();
        session.setAttribute("user", user);
		this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
	}

}
