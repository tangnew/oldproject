package com.army.building.aop;

public interface UserService {
	public void add();

	public void around();

	public User returns(User user);

	public void exceptions();
	
	public void addUser(User user);
}
