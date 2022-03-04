package com.bomberman.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bomberman.beans.Rank;

public class RankingDaoImp implements RankingDao{
	
	private DaoFactory daoFactory;
	
	public RankingDaoImp(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public ArrayList<Rank> getRanking() {
		Connection connexion = null;
		ResultSet rs = null;
		PreparedStatement preparedStatement = null;
		ArrayList<Rank> ranks = new ArrayList<>();
	
		try {
			connexion = daoFactory.getConnection();
			preparedStatement = connexion.prepareStatement("SELECT pseudo, game_won AS wonGames "
					+ "FROM Player "
					+ "ORDER BY wonGames DESC;");
            rs = preparedStatement.executeQuery();
            
            while(rs.next()) {
            	Rank rank = new Rank();
            	rank.setPseudo(rs.getString("pseudo"));
            	rank.setNbGameWon(rs.getInt("wonGames"));
            	ranks.add(rank);
            }
            return ranks;
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
