package com.bomberman.dao;

import java.util.ArrayList;

import com.bomberman.beans.User;

public interface UserDao {
	
	void addUser(User user);
	ArrayList<User> getAllUser();
	User getInfo(User user);
	boolean connect(User user);
	boolean changePseudo(User user);
	boolean changePassword(User user);
}
