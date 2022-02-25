package com.bomberman.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
            preparedStatement.setString(2, user.getPassword());
			
            rs = preparedStatement.executeQuery();
            
            while(rs.next()) {
            	String login = rs.getString("login");
            	String pseudo = rs.getString("pseudo");
            	
            	user.setLogin(login);
            	user.setPseudo(pseudo);
            }
            
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return user;
	}


	@Override
	public boolean connexion(User user) {
		
		boolean status = false;
		
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
	public void ajouter(User user) {
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
	public ArrayList<User> allUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean changePseudo(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean changeMdp(User user) {
		// TODO Auto-generated method stub
		return false;
	}

}
