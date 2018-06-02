package com.army.building.service;

import com.army.building.model.User;

public interface UserService {
	public void add(User user);

	public User update(User user);
	
	public void delete(User user, User user1);

	public void exceptions();
}
