package com.tjj.dao;

import org.junit.Test;

import com.tjj.dao.impl.LevelDaoImpl;
import com.tjj.model.Game;
import com.tjj.model.Level;
import com.tjj.util.GenerateUuid;

public class LevelDaoTest {
	@Test
	public void testAddLevel00() {
		Game game = new Game();
		game.setGameGuid(GenerateUuid.getUuid());
		game.setName("game3");

		Level level = new Level();
		level.setGame(game);
		level.setLevelGuid(GenerateUuid.getUuid());
		level.setName("level3");
		
		Level level1 = new Level();
		level1.setGame(game);
		level1.setLevelGuid(GenerateUuid.getUuid());
		level1.setName("level4");
		
		LevelDao dao = new LevelDaoImpl();
		dao.addLevel(level);
		dao.addLevel(level1);
	}
	
	@Test
	public void testGetLevel00() {
		LevelDao dao = new LevelDaoImpl();
		Level level1  = dao.findLevelById(1);
		System.out.println(level1.getGame());
	}
}
