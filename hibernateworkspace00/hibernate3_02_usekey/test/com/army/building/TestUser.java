package com.army.building;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.army.building.model.User;
import com.army.building.model.UserKey;
import com.util.HibernateUtils;

public class TestUser {
	@Test
	public void add0() {
		User user = new User();
		user.setId(new UserKey(3, "ab"));
		user.setName("zhangsan");
		Session session = HibernateUtils.getSession();
		Transaction tran = session.beginTransaction();
		session.save(user);
		tran.commit();
	}
	
	@Test
	public void get0() {
		User user = new User();
		Session session = HibernateUtils.getSession();
		Transaction tran = session.beginTransaction();
		user = (User)session.get(User.class,new UserKey(3, "ab"));
		System.out.println(user.getName());
		tran.commit();
	}
}
