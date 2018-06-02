package com.factory;

import com.modual.User;

public class StaticInstanceFactory {
	public User getUser(int id, String name) {
		return new User(id, name);
	}
}
