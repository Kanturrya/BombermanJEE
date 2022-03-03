package com.bomberman.forms;

import javax.servlet.http.HttpServletRequest;

import com.bomberman.dao.DaoFactory;
import com.bomberman.dao.GamePlayedDao;

public class GamePlayedForm {
	
	public boolean verifyServer(HttpServletRequest req) {
		
		DaoFactory daoFactory = DaoFactory.getInstance();
		GamePlayedDao gamePlayedDao = daoFactory.getGamePlayedDao();
		
		return gamePlayedDao.addGamePlayed(Integer.parseInt(req.getParameter("userid")), Integer.parseInt(req.getParameter("gameid")));
	}
}
