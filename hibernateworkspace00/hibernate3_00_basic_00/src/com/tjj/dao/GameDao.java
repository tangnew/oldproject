package com.tjj.dao;

import com.tjj.model.Game;

public interface GameDao {
	public void addGame(Game game);
	
	public Game findGameById(Integer id);
}
