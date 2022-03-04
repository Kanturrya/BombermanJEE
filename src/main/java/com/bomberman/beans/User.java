package com.bomberman.beans;

public class User {
	private String login;
	private String password;
	private String pseudo;
	private String id;
	private int game_played;
	private int game_won;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPseudo() {
		return pseudo;
	}
	
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	
	public int getGame_played() {
		return game_played;
	}
	
	public void setGame_played(int game_played) {
		this.game_played = game_played;
	}
	
	public int getGame_won() {
		return game_won;
	}
	
	public void setGame_won(int game_won) {
		this.game_won = game_won;
	}
	
}
