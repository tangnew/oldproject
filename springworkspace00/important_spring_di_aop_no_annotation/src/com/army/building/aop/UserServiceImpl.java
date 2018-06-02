package com.army.building.aop;

public class UserServiceImpl implements UserService {

	@Override
	public void add() {
		System.out.println("userService Add");
	}

	@Override
	public void around() {
		System.out.println("userService around");
	}

	@Override
	public User returns(User user) {
		System.out.println("userService returns:" + user.getName() + " "
				+ user.hashCode());
		System.out.println("over");
		return user;
	}

	@Override
	public void exceptions() {
		System.out.println("userService exceptions");
		throw new RuntimeException("test exception!");
	}

	@Override
	public void addUser(User user) {
		System.out.println("userService addUser:" + user.getName());
		user.setName("d");
	}

}
