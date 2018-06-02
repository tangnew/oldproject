package com.tjj.dao;

import org.junit.Test;

import com.tjj.dao.impl.GameDaoImpl;
import com.tjj.model.Game;
import com.tjj.model.Level;
import com.tjj.util.GenerateUuid;

public class GameDaoTest {
	@Test
	public void testAddGame00() {
		Game game = new Game();
		game.setGameGuid(GenerateUuid.getUuid());
		game.setName("game1");

		GameDao dao = new GameDaoImpl();
		dao.addGame(game);
	}

	@Test
	public void testGetGameById00() {
		GameDao dao = new GameDaoImpl();
		Game game = dao.findGameById(2);
		for(Level l : game.getLevels()){
			System.out.println(l);
		}
		System.out.println(game);
	}
}
