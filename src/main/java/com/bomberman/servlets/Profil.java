package com.bomberman.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bomberman.forms.ProfileForm;

/**
 * Servlet implementation class Profil
 */
@WebServlet("/Profil")
public class Profil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Profil() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    private void setAttributes(HttpServletRequest request) {
    	request.setAttribute("played", 0);
		request.setAttribute("won", 0);
		request.setAttribute("ratio", "0%");
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
