package com.bomberman.dao;

import java.util.ArrayList;

import com.bomberman.beans.Server;

public interface ServerDao {
	
	ArrayList<Server> getServerlist();
	Server addServer(Server server);
	boolean removeServer(Server server);
	Server getServerInfo(Server server);
}
