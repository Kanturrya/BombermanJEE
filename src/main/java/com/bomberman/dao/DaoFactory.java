package com.bomberman.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.bomberman.dao.RankingDao;
import com.bomberman.dao.ServerDao;

public class DaoFactory {
	
	private String url;
	private String username;
	private String password;
	
	public DaoFactory(String url, String username, String password) {
		this.url = url;
		this.username = username;
		this.password = password;
	}
	
	public static DaoFactory getInstance() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch(ClassNotFoundException e) {
			
		}
		
		DaoFactory instance = new DaoFactory("jdbc:mariadb://localhost:3306/Bomberman", "etud", "");
		
		return instance;
	}
	
	public Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url, username, password);
	}
	
	public UserDao getUserDao(){
		return new UserDaoImp(this);
	}
	
	public RankingDao getRankingDao() {
		return new RankingDaoImp(this);
	}

	public ServerDao getServerDao(){
		return new ServerDaoImp(this);
	}
	public GamePlayedDao getGamePlayedDao() {
		return new GamePlayedDaoImp(this);
	}

	public GameWonDao getGameWonDao(){
		return new GameWonDaoImp(this);
	}
	
	public GameDao getGameDao(){
		return new GameDaoImp(this);
	}
}
