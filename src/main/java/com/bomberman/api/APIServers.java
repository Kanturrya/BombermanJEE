package com.bomberman.api;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bomberman.beans.Server;
import com.bomberman.beans.User;
import com.bomberman.forms.ConnectionForm;
import com.bomberman.forms.ServerForm;


@WebServlet("/APIServersAdd")
public class APIServers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public APIServers() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServerForm serverForm = new ServerForm();

		Server server = serverForm.verifyServer(request);
		
		PrintWriter outpout = new PrintWriter(response.getOutputStream(), true);
		
		if(server != null) {
			outpout.println(server.getId());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServerForm serverForm = new ServerForm();
		
		System.out.println(request.getParameter("id"));
		
		boolean isOk = serverForm.deleteServer(request);
		
		if(isOk) {
			System.out.println("Deleted");;
		}
	}

}
