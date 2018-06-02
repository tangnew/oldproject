package com.tjj.dao;

import com.tjj.model.Level;

public interface LevelDao {
	public void addLevel(Level Level);
	
	public Level findLevelById(Integer id);
}
