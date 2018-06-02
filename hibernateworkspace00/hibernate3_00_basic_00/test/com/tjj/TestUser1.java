package com.tjj;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

public class TestUser1 {
	// 增加记录方法1,对于瞬时对象,save只有增加操作.而对于持续化对象，则是做更改操作
	@Test
	public void testAdd() {
		User user = new User();
		user.setName("lisi_x");
		user.setAddress("cd");
		user.setAge(12);
		user.setId(3);

		Session session = HibernateUtil.getSession();
		Transaction tran = session.beginTransaction();
		tran.begin();
		session.save(user);
		tran.commit();
	}

	// 增加记录方法2
	@Test
	public void testAdd0() {
		Session session = HibernateUtil.getSession();
		Transaction tran = session.beginTransaction();
		tran.begin();
		User user = (User) session.get(User.class, 5);
		user.setName(user.getName() + "XXX");
		session.save(user);
		tran.commit();
	}

	// 增加记录方法3 使用saveOrUpdate增加记录.如果瞬时对象不存在的话,则是做增加操作。
	@Test
	public void testAdd1() {
		User user = new User();
		user.setName("zhangsan");
		user.setAddress("cd");
		user.setAge(12);

		Session session = HibernateUtil.getSession();
		Transaction tran = session.beginTransaction();
		tran.begin();
		session.saveOrUpdate(user);
		tran.commit();
	}

	// 更新记录1 使用saveOrUpdate更新记录.如果瞬时对象存在的话,则是做更新操作。
	@Test
	public void testUpdate0() {
		User user = new User();
		user.setName("zhangsan_x");
		user.setAddress("cd");
		user.setAge(12);
		user.setId(4);

		Session session = HibernateUtil.getSession();
		Transaction tran = session.beginTransaction();
		tran.begin();
		session.saveOrUpdate(user);
		tran.commit();
	}

	// 修改记录,如果对象是持续化对象的话,则不需要使用update或则saveOrUpdate对象方法来进行修改
	@Test
	public void testUpdate1() {
		Session session = HibernateUtil.getSession();
		Transaction tran = session.beginTransaction();
		tran.begin();
		User user = (User) session.get(User.class, 1);
		user.setAddress("shangdong");
		tran.commit();
	}

	// 使用update方法来修改瞬时对象
	@Test
	public void testUpdate2() {
		User user = new User();
		user.setName("zhangsan_x_x");
		user.setAddress("cd");
		user.setAge(12);
		user.setId(5);

		Session session = HibernateUtil.getSession();
		Transaction tran = session.beginTransaction();
		tran.begin();
		session.update(user);
		tran.commit();
	}

	// 删除对象
	@Test
	public void testDelete() {
		Session session = HibernateUtil.getSession();
		Transaction tran = session.beginTransaction();
		tran.begin();
		User user = (User) session.get(User.class, 1);
		session.delete(user);
		tran.commit();
	}

	// 删除瞬时对象
	@Test
	public void testDelete1() {
		User user = new User();
		user.setId(2);
		Session session = HibernateUtil.getSession();
		Transaction tran = session.beginTransaction();
		tran.begin();
		session.delete(user);
		tran.commit();
	}

	// 显示所有记录
	@Test
	public void testList() {
		Session session = HibernateUtil.getSession();
		Transaction tran = session.beginTransaction();
		tran.begin();
		Query query = session.createQuery("from User");
		@SuppressWarnings("unchecked")
		List<User> users = query.list();
		for (User user : users) {
			System.out.println(user);
		}
		tran.commit();
	}

	// 测试load方法,延迟加载.系统默认是延迟加载.
	// load与get不同之处：get是及时加载，如果不存在记录，则返回null；
	// 而load是延迟加载，返回的是代理对象，如果返回对象不存在的话，则抛出异常
	@Test
	public void testGet0() {
		Session session = HibernateUtil.getSession();
		Transaction tran = session.beginTransaction();
		tran.begin();
		User user = (User) session.get(User.class, 4);
		System.out.println(user);
		tran.commit();
	}

	@Test
	public void testGet1() {
		Session session = HibernateUtil.getSession();
		Transaction tran = session.beginTransaction();
		tran.begin();
		User user = (User) session.get(User.class, 41);
		System.out.println(user);
		tran.commit();
	}

	@Test
	public void testLoad0() {
		Session session = HibernateUtil.getSession();
		Transaction tran = session.beginTransaction();
		tran.begin();
		User user = (User) session.load(User.class, 4);
		System.out.println(user);
		tran.commit();
	}

	@Test
	public void testLoad1() {
		Session session = HibernateUtil.getSession();
		Transaction tran = session.beginTransaction();
		tran.begin();
		User user = (User) session.load(User.class, 41);
		System.out.println(user);
		tran.commit();
	}

	// evict将某个对象从持续化变成托管对象
	// saveOrUpdate、update、persist将某个对象从瞬时变成持续化
	// clear将session清理空，持续化对象全部变成托管对象
	// Update 和 Merge方法的区别：在session缓存中有两个相同ID的实体时，update更新会报异常
	// Update 和 Lock(淘汰)方法的区别
	@Test
	public void test() {
		Session session = HibernateUtil.getSession();
		Transaction tran = session.beginTransaction();
		tran.begin();
		User user = (User) session.load(User.class, 41);
		session.update(user);
		session.evict(user);
		session.persist(user);
		session.clear();
		System.out.println(user);
		tran.commit();
	}

	//Query中list与iterate区别:list是发送一条查询命令,而iterate是发送多条
	@Test
	public void testIterate() {
		Session session = HibernateUtil.getSession();
		Transaction tran = session.beginTransaction();
		tran.begin();
		Query query = session.createQuery("from com.tjj.User");
		Iterator<User> iter = query.iterate();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
		tran.commit();
	}

}
