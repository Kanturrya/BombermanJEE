package com.bomberman.forms;

import javax.servlet.http.HttpServletRequest;

import com.bomberman.dao.DaoFactory;
import com.bomberman.dao.GameWonDao;

public class GameWonForm {

	public boolean verifyServer(HttpServletRequest req) {
		DaoFactory daoFactory = DaoFactory.getInstance();
		GameWonDao gameWonDao = daoFactory.getGameWonDao();
		
		return gameWonDao.addGameWon(Integer.parseInt(req.getParameter("userid")), Integer.parseInt(req.getParameter("gameid")));
	}
}
