package com.bomberman.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GameDaoImp implements GameDao{

	private DaoFactory daoFactory;

	public GameDaoImp(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public int addGame(String map) {
		Connection connexion = null;
		ResultSet rs = null;
		PreparedStatement preparedStatement = null;
		Statement statement = null;

		try {
			connexion = daoFactory.getConnection();
			preparedStatement = connexion.prepareStatement("INSERT INTO Game(map) VALUE(?);");
			preparedStatement.setString(1, map);
			preparedStatement.executeQuery();
			
			statement = connexion.createStatement();
			rs = statement.executeQuery("SELECT DISTINCT LAST_INSERT_ID() FROM Game");

			while(rs.next()) {
				return rs.getInt("LAST_INSERT_ID()");
			}

		} catch(SQLException e) {
			e.printStackTrace();
		}

		return -1;
	}

}