package com.bomberman.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bomberman.forms.ConnectionForm;


@WebServlet("/Connexion")
public class Connexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Connexion() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/connexion.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ConnectionForm form = new ConnectionForm();
		
		form.verifyId(request);
		
		if(form.isOk() == false) {
			request.setAttribute("form", form);
			this.getServletContext().getRequestDispatcher("/WEB-INF/connexion.jsp").forward(request, response);
		} else {
			request.setAttribute("form", form);
			this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
		}
		
	}

}
