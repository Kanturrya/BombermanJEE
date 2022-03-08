package com.bomberman.dao;

import com.bomberman.beans.User;

public interface UserDao {
	
	void addUser(User user);
	User getInfo(User user);
	boolean exist(int id);
	boolean connect(User user);
	boolean changePseudo(int id, String pseudo);
	boolean changePassword(int id, String password);
	boolean existLogin(User user);
	void addGamePlayed(int id);
	void addGameWon(int id);
}
