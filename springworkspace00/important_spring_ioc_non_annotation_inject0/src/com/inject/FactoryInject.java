package com.inject;

import com.modual.User;

public class FactoryInject {
	public User getInstanceByFactoryBean(int id, String name) {
		return new User(id, name);
	}

	public static User getInstanceByStaticFactory(int id, String name) {
		return new User(id, name);
	}
}
