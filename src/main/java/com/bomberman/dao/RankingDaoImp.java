package com.bomberman.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bomberman.beans.Game;

public class RankingDaoImp implements RankingDao{
	
	private DaoFactory daoFactory;
	
	public RankingDaoImp(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public ArrayList<String> getRanking() {
		Connection connexion = null;
		ResultSet rs = null;
		PreparedStatement preparedStatement = null;
		ArrayList<String> users = new ArrayList<>();
	
		try {
			connexion = daoFactory.getConnection();
			preparedStatement = connexion.prepareStatement("SELECT Player.id AS Player_ID,pseudo,COUNT(*) AS wonGames "
					+ "FROM Player INNER JOIN GameWon ON Player.id = GameWon.Player_ID "
					+ "GROUP BY Player_ID ORDER BY COUNT(*) DESC;");
            rs = preparedStatement.executeQuery();
            
            while(rs.next()) {
            	users.add(rs.getInt("Player_ID")+";"+rs.getString("pseudo")+";"+rs.getInt("wonGames"));
            }
            return users;
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
