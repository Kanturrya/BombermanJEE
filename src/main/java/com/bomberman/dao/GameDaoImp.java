package com.bomberman.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bomberman.beans.Game;

public class GameDaoImp implements GameDao{
	
	private DaoFactory daoFactory;
	
	public GameDaoImp(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void addGame(Game game) {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connexion = daoFactory.getConnection();
			preparedStatement = connexion.prepareStatement("INSERT INTO Game(date, timer, ip, port) VALUES(?,?,?,?);");
			
			preparedStatement.setDate(1, game.getDate());
			preparedStatement.setInt(2, game.getTimer());
			preparedStatement.setString(3, game.getIp());
			preparedStatement.setInt(4, game.getPort());
			preparedStatement.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Game> getAllGames() {
		Connection connexion = null;
		ResultSet rs = null;
		PreparedStatement preparedStatement = null;
		ArrayList<Game> games = new ArrayList<>();
	
		try {
			connexion = daoFactory.getConnection();
			preparedStatement = connexion.prepareStatement("SELECT * FROM Game;");
            rs = preparedStatement.executeQuery();
            
            while(rs.next()) {
            	Game game = new Game();
            	game.setDate(rs.getDate("date"));
            	game.setTimer(rs.getInt("timer"));
            	game.setIp(rs.getString("ip"));
            	game.setPort(rs.getInt("port"));
            	games.add(game);
            }
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return games;
	}

	@Override
	public Game getGameById(int id) {
		Connection connexion = null;
		ResultSet rs = null;
		PreparedStatement preparedStatement = null;
	
		try {
			connexion = daoFactory.getConnection();
			preparedStatement = connexion.prepareStatement("SELECT * FROM Game WHERE id = ?;");
			preparedStatement.setInt(0, id);
            rs = preparedStatement.executeQuery();
            
            if(rs.next()) {
            	Game game = new Game();
            	game.setDate(rs.getDate("date"));
            	game.setTimer(rs.getInt("timer"));
            	game.setIp(rs.getString("ip"));
            	game.setPort(rs.getInt("port"));
            	return game;
            }
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
