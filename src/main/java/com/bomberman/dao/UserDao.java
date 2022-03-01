package com.bomberman.dao;

import java.util.ArrayList;

import com.bomberman.beans.User;

public interface UserDao {
	
	void ajouter(User user);
	ArrayList<User> allUser();
	User getInfo(User user);
	boolean connexion(User user);
	boolean changePseudo(User user);
	boolean changeMdp(User user);
}
