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
	public int addGame() {

		Connection connexion = null;
		ResultSet rs = null;
		Statement statement = null;

		try {
			
			connexion = daoFactory.getConnection();
			statement = connexion.createStatement();
			statement.executeQuery("INSERT INTO Game() VALUE();");
			rs = statement.executeQuery("SELECT DISTINCT LAST_INSERT_ID() FROM Game;");

			while(rs.next()) {
				return rs.getInt("LAST_INSERT_ID()");
			}

		} catch(SQLException e) {
			e.printStackTrace();
		}

		return -1;
	}

}