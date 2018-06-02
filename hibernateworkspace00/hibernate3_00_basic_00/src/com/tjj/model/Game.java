package com.tjj.model;

import java.util.HashSet;
import java.util.Set;

public class Game {
	private Integer id;
	private String gameGuid;
	private String name;
	private Set<Level> levels = new HashSet<>();
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getGameGuid() {
		return gameGuid;
	}
	public void setGameGuid(String gameGuid) {
		this.gameGuid = gameGuid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Level> getLevels() {
		return levels;
	}
	public void setLevels(Set<Level> levels) {
		this.levels = levels;
	}
	@Override
	public String toString() {
		return "Game [id=" + id + ", gameGuid=" + gameGuid + ", name=" + name
				+ "]";
	}
	
}
