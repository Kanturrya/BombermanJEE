package com.bomberman.dao;

import java.util.ArrayList;

import com.bomberman.beans.Game;
import com.bomberman.beans.User;

public interface RankingDao {
	ArrayList<String> getRanking();
}
