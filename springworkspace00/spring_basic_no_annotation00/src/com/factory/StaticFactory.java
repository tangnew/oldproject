package com.factory;

import com.modual.User;

public class StaticFactory {
	public static User getUser() {
		return new User(2, "static factory");
	}
}
