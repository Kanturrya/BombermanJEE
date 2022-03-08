package com.bomberman.forms;

import javax.servlet.http.HttpServletRequest;

import com.bomberman.dao.DaoFactory;
import com.bomberman.dao.GameDao;

public class GameForm {
	
	public int addGame(HttpServletRequest req) {

		DaoFactory daoFactory = DaoFactory.getInstance();
		GameDao gameDao = daoFactory.getGameDao();
		
		return gameDao.addGame();
	}
}
