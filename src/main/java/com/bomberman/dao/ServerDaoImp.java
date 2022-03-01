package com.bomberman.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.bomberman.beans.Server;
import com.bomberman.security.Hashing;

public class ServerDaoImp implements ServerDao{
	
	private DaoFactory daoFactory;
	
	public ServerDaoImp(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}
	
	@Override
	public ArrayList<Server> getServerlist() {
		ArrayList<Server> servers = new ArrayList<>();
		
		Connection connexion = null;
		ResultSet rs = null;
		Statement statement = null;
	
		try {
			connexion = daoFactory.getConnection();
			statement = connexion.createStatement();
			rs = statement.executeQuery("SELECT * FROM Game");
            
            while(rs.next()) {
            	
            	Server server = new Server();
            	server.setId(rs.getInt("id"));
            	server.setDate(rs.getDate("date"));
            	server.setIp(rs.getString("ip"));
            	server.setPort(rs.getInt("port"));
            	server.setTimer(rs.getInt("timer"));
            	System.out.println(server.getIp());
            	servers.add(server);
            }
            
		} catch(SQLException e) {
			e.printStackTrace();
		}
		System.out.println(servers.toString());
		return servers;
	}

}
