package com.bomberman.dao;

import com.bomberman.beans.User;

public interface UserDao {
	
	void addUser(User user);
	User getInfo(User user);
	boolean connect(User user);
	boolean changePseudo(User user);
	boolean changePassword(User user);
	boolean exist(int id);
	boolean existLogin(User user);
	void addGamePlayed(int id);
	void addGameWon(int id);
}
