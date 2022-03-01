package com.bomberman.dao;

import java.util.ArrayList;

import com.bomberman.beans.Game;
import com.bomberman.beans.User;

public interface GameDao {
	
	void addGame(Game game);
	ArrayList<Game> getAllGames();
	Game getGameById(int id);
	ArrayList<String> getRanking();
}
