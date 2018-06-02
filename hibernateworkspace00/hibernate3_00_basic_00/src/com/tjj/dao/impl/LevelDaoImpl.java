package com.tjj.dao.impl;

import com.tjj.dao.AbstractDao;
import com.tjj.dao.LevelDao;
import com.tjj.model.Level;

public class LevelDaoImpl extends AbstractDao<Level> implements LevelDao {

	@Override
	public void addLevel(Level Level) {
			super.save(Level);
	}

	@Override
	public Level findLevelById(Integer id) {
		return super.get(Level.class, id);
	}

}
