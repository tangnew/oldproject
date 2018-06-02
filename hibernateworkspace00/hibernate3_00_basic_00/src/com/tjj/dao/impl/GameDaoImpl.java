package com.tjj.dao.impl;

import com.tjj.dao.AbstractDao;
import com.tjj.dao.GameDao;
import com.tjj.model.Game;

public class GameDaoImpl extends AbstractDao<Game> implements GameDao {

	@Override
	public void addGame(Game game) {
		super.save(game);

	}

	@Override
	public Game findGameById(Integer id) {
		return super.get(Game.class, id);
	}

}
