package com.bomberman.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GamePlayedDaoImp implements GamePlayedDao{
	
	private DaoFactory daoFactory;
	
	public GamePlayedDaoImp(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public boolean addGamePlayed(int user, int game) {
		
		Connection connexion = null;
		ResultSet rs = null;
		PreparedStatement preparedStatement = null;
		
		try {
			
			UserDaoImp userDao = new UserDaoImp(daoFactory);
			
			if(userDao.exist(user)) {
				connexion = daoFactory.getConnection();
				preparedStatement = connexion.prepareStatement("INSERT INTO GamePlayed(Player_ID, Game_ID) VALUE(?,?)");
				
				preparedStatement.setInt(1, user);
				preparedStatement.setInt(2, game);
				
				int x = preparedStatement.executeUpdate();
				
				if(x == 1) {
					return true;
				}
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
}
