package com.bomberman.forms;

import javax.servlet.http.HttpServletRequest;

import com.bomberman.beans.Server;
import com.bomberman.dao.DaoFactory;
import com.bomberman.dao.ServerDao;


public class ServerForm {
	
	public Server verifyServer(HttpServletRequest req) {
		Server server = new Server();
		
		if(req.getParameter("ip") == null || req.getParameter("port") == null || !req.getParameter("token").equals("791cdc4f-1812-4078-a265-4feed8f2af2b")) {
			return null;
		}
		
		server.setIp(req.getParameter("ip"));
		server.setPort(Integer.parseInt(req.getParameter("port")));
		
		DaoFactory daoFactory = DaoFactory.getInstance();
		ServerDao serverDao = daoFactory.getServerDao();
		
		if(serverDao.addServer(server) != null) {
			return server;
		} 
		return null;
	}
	
	public boolean deleteServer(HttpServletRequest req) {
		
		Server server = new Server();
		
		if(req.getParameter("id") == null || !req.getParameter("token").equals("047ff0b3-d5cf-4549-b46a-1f876984c93d")) {
			return false;
		}
		
		server.setId(Integer.parseInt(req.getParameter("id")));
		
		DaoFactory daoFactory = DaoFactory.getInstance();
		ServerDao serverDao = daoFactory.getServerDao();
		
		
		return serverDao.removeServer(server); 
	}
}
