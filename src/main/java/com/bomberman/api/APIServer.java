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
import com.bomberman.dao.DaoFactory;
import com.bomberman.dao.ServerDao;
import com.bomberman.forms.ConnectionForm;


@WebServlet("/APIServersAdd")
public class APIServer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public APIServer() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("ip") == null || request.getParameter("port") == null || !request.getParameter("token").equals("791cdc4f-1812-4078-a265-4feed8f2af2b")) {
			response.sendRedirect(request.getContextPath() + "/index");
			return;
		}
		
		Server server = new Server();
		server.setIp(request.getParameter("ip"));
		server.setPort(Integer.parseInt(request.getParameter("port")));
		
		DaoFactory daoFactory = DaoFactory.getInstance();
		ServerDao serverDao = daoFactory.getServerDao();
		server = serverDao.addServer(server);

		PrintWriter output = new PrintWriter(response.getOutputStream(), true);
		
		if(server != null) {
			output.println(server.getId());
		}
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("id") == null || !request.getParameter("token").equals("047ff0b3-d5cf-4549-b46a-1f876984c93d")) {
			return;
		}
		
		Server server = new Server();
		server.setId(Integer.parseInt(request.getParameter("id")));
		
		DaoFactory daoFactory = DaoFactory.getInstance();
		ServerDao serverDao = daoFactory.getServerDao();
		serverDao.removeServer(server);
	}

}
