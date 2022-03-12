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
import com.bomberman.forms.ProfileForm;

/**
 * Servlet implementation class Profil
 */
@WebServlet("/Profil")
public class Profil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private UserDao userDao;
    
    public Profil() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init() throws ServletException{
    	DaoFactory daoFactory = DaoFactory.getInstance();
    	this.userDao = daoFactory.getUserDao();
    }
    
    private void setAttributes(HttpServletRequest request) {
    	HttpSession session = request.getSession();
    	double ratio = 0.0;
    	int played = userDao.getGamePlayed((User)session.getAttribute("user"));
    	int won = userDao.getGameWon((User)session.getAttribute("user"));
    	
    	if(played != 0) {
    		ratio = (double)won/played;
    	}
    	
    	request.setAttribute("played", played);
		request.setAttribute("won", won);
		request.setAttribute("ratio", ratio*100);
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
        
		if(session.getAttribute("user") != null) {
			this.setAttributes(request);
			this.getServletContext().getRequestDispatcher("/WEB-INF/profil.jsp").forward(request, response);
		} else {
			response.sendRedirect("index");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		if(session.getAttribute("user") != null) {
			ProfileForm form = new ProfileForm();
			form.updateProfile(request);
			
			this.setAttributes(request);
			this.getServletContext().getRequestDispatcher("/WEB-INF/profil.jsp").forward(request, response);
		} else {
			response.sendRedirect("index");
		}
	}

}
