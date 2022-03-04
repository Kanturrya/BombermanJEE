package com.bomberman.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bomberman.beans.User;
import com.bomberman.security.Hashing;

public class UserDaoImp implements UserDao {
	
	private DaoFactory daoFactory;
	
	public UserDaoImp(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}
	
	
	@Override
	public User getInfo(User user) {
		Connection connexion = null;
		ResultSet rs = null;
		PreparedStatement preparedStatement = null;
	
		try {
			connexion = daoFactory.getConnection();
			preparedStatement = connexion.prepareStatement("SELECT * FROM Player WHERE login = ? AND password = ?");
			preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, Hashing.hash(user.getPassword()));
			
            rs = preparedStatement.executeQuery();
            
            while(rs.next()) {
            	
            	String login = rs.getString("login");
            	String pseudo = rs.getString("pseudo");
            	String id = rs.getString("id");
            	
            	user.setLogin(login);
            	user.setPseudo(pseudo);
            	user.setId(id);
            }
            
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return user;
	}


	@Override
	public boolean connect(User user) {
		Connection connexion = null;
		ResultSet rs = null;
		PreparedStatement preparedStatement = null;
	
		try {
			connexion = daoFactory.getConnection();
			preparedStatement = connexion.prepareStatement("SELECT * FROM Player WHERE login = ?");
			preparedStatement.setString(1, user.getLogin());
			
            rs = preparedStatement.executeQuery();
            while(rs.next()) {
	            String passDB = rs.getString("password");
				return Hashing.check(passDB, user.getPassword());  
            }
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void addUser(User user) {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connexion = daoFactory.getConnection();
			preparedStatement = connexion.prepareStatement("INSERT INTO Player(login, password, pseudo) VALUES(?,?,?);");
			
			preparedStatement.setString(1, user.getLogin());
			
			preparedStatement.setString(2, user.getPassword());
			
			preparedStatement.setString(3, user.getPseudo());
			preparedStatement.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public boolean changePseudo(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean changePassword(User user) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean exist(int id) {
		Connection connexion = null;
		ResultSet rs = null;
		PreparedStatement preparedStatement = null;
	
		try {
			connexion = daoFactory.getConnection();
			preparedStatement = connexion.prepareStatement("SELECT * FROM Player WHERE id = ?");
			preparedStatement.setInt(1, id);
			
            rs = preparedStatement.executeQuery();
			if(rs.next()) {
				return true;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}


	@Override
	public void addGamePlayed(int id) {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connexion = daoFactory.getConnection();
			preparedStatement = connexion.prepareStatement("UPDATE Player SET game_played = game_played + 1 WHERE id=?;");
			preparedStatement.setInt(1, id);
			preparedStatement.executeQuery();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}


	@Override
	public void addGameWon(int id) {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connexion = daoFactory.getConnection();
			preparedStatement = connexion.prepareStatement("UPDATE Player SET game_won = game_won + 1 WHERE id=?;");
			preparedStatement.setInt(1, id);
			preparedStatement.executeQuery();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
