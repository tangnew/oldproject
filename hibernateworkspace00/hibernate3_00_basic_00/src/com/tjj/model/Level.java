package com.tjj.model;

public class Level {
	private Integer id;
	private String levelGuid;
	private String name;
	private Game game;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLevelGuid() {
		return levelGuid;
	}

	public void setLevelGuid(String levelGuid) {
		this.levelGuid = levelGuid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	@Override
	public String toString() {
		return "Level [id=" + id + ", levelGuid=" + levelGuid + ", name="
				+ name + ", game=" + game + "]";
	}



}
