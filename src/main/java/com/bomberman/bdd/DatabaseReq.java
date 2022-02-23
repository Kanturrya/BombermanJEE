package com.bomberman.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bomberman.beans.User;

public class DatabaseReq {

	private Connection connexion;
	
	public User getUserInfo() {
		
		
		User user = new User();
		
		Statement statement = null;
		ResultSet resultat = null;
		
		loadDatabase();
		
		try {
			
			statement = connexion.createStatement();
			
			resultat = statement.executeQuery("SELECT pseudo, login FROM Player WHERE pseudo='Bois'");
			
			while(resultat.next()) {
				String pseudo = resultat.getString("pseudo");
				String login = resultat.getString("login");
				
				user.setLogin(login);
				user.setPseudo(pseudo);
			}
			
			
		} catch(SQLException e) {
			
		} finally {
			
			try {
				if(resultat != null)
					resultat.close();
				if(statement != null)
					statement.close();
				if(connexion != null)
					connexion.close();
			} catch(SQLException e) {
			}
		}
		return user;
	}
	
	
	private void loadDatabase() {
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		}catch(ClassNotFoundException e) {}
		
		String url = "jdbc:mariadb://localhost:3306/Bomberman";
		try {
			connexion = DriverManager.getConnection(url, "etud", "");
			System.out.println("Connected database successfully...");
		}catch(SQLException e) {
			System.out.println("Error!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			e.printStackTrace();
		}
		
	}
}
