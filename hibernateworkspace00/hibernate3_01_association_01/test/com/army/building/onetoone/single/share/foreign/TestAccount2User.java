package com.army.building.onetoone.single.share.foreign;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.util.HibernateUtils;

public class TestAccount2User {

	// 一对一的双向关联.从多端开始存储
	@Test
	public void testAdd0() {
		Session session = HibernateUtils.getSession();
		Transaction trans = session.beginTransaction();
		trans.begin();

		User user = new User();
		user.setName("张三");

		Account account = new Account();
		account.setName("zhangsan");
		account.setUser(user);
		user.setAccount(account);

		session.save(account);
		trans.commit();

	}

	// 一对一的单向关联.从多端开始存储
	@Test
	public void testAdd1() {
		Session session = HibernateUtils.getSession();
		Transaction trans = session.beginTransaction();
		trans.begin();

		User user = new User();
		user.setName("张三");

		Account account = new Account();
		account.setName("zhangsan");
		account.setUser(user);// 去掉该行就会报错,因为没有主键
		user.setAccount(account);
		session.save(account);
		trans.commit();

	}

	// 一对一的双向关联，从端查询.从端采用外键
	@Test
	public void testAdd2() {
		Session session = HibernateUtils.getSession();
		Transaction trans = session.beginTransaction();
		trans.begin();

		User user = new User();
		user.setName("zhangsan_user");
		Account account = new Account();
		account.setId(88);
		account.setName("zhangsan");
		account.setUser(user);
		user.setAccount(account);

		session.save(account);
		trans.commit();
	}

	@Test
	public void testFind0() {
		Session session = HibernateUtils.getSession();
		Transaction trans = session.beginTransaction();
		trans.begin();
		User user = (User) session.get(User.class, 4);
		System.out.println(user.getName() + " " + user.getAccount().getName()
				+ " " + user.getAccount().getUser().getName());
		trans.commit();
	}
}
