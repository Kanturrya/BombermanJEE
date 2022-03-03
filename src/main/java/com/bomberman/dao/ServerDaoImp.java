package com.bomberman.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.bomberman.beans.Server;

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
			rs = statement.executeQuery("SELECT * FROM Server");
            
            while(rs.next()) {
            	
            	Server server = new Server();
            	server.setId(rs.getInt("id"));
            	server.setIp(rs.getString("ip"));
            	server.setPort(rs.getInt("port"));
            	servers.add(server);
            }
            
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return servers;
	}
	
	@Override
	public Server getServerInfo(Server server) {
		
		Connection connexion = null;
		ResultSet rs = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connexion = daoFactory.getConnection();
			preparedStatement = connexion.prepareStatement("SELECT * FROM Game WHERE ip = ? AND port = ?;");
			
			preparedStatement.setString(1, server.getIp());
			preparedStatement.setInt(2, server.getPort());
			
			rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				server.setId(rs.getInt("id"));
				server.setIp(rs.getString("ip"));
				server.setPort(rs.getInt("port"));
			}
			
			return server;
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Server addServer(Server server) {
		
		Connection connexion = null;
		ResultSet rs = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connexion = daoFactory.getConnection();
			preparedStatement = connexion.prepareStatement("INSERT INTO Game(ip, port) VALUE(?,?);");
			
			preparedStatement.setString(1, server.getIp());
			preparedStatement.setInt(2, server.getPort());
			
			int x = preparedStatement.executeUpdate();

		} catch(SQLException e) {
			e.printStackTrace();
		}
		return getServerInfo(server);
	}

	@Override
	public boolean removeServer(Server server) {
		
		Connection connexion = null;
		ResultSet rs = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connexion = daoFactory.getConnection();
			preparedStatement = connexion.prepareStatement("DELETE FROM Game WHERE id = ?;");
			
			preparedStatement.setInt(1, server.getId());
			
			int x = preparedStatement.executeUpdate();
			
			if(x == 1) {
				return true;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	

}
