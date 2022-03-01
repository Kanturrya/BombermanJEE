package com.bomberman.dao;

import java.util.ArrayList;

import com.bomberman.beans.Game;

public interface GameDao {
	
	void addGame(Game game);
	ArrayList<Game> getAllGames();
	Game getGameById(int id);
}
