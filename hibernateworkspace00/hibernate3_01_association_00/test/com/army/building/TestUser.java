package com.army.building;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.util.HibernateUtil;

public class TestUser {

	@Test
	public void add0() {
		Session session = HibernateUtil.getSession();
		Transaction tran = session.beginTransaction();
		tran.begin();
		User user = new User();
		user.setName("zhangssan1");
		user.setAddress("chengdu");
		user.setAge(17);
		user.setStory("testestesttssssssssssss");
		try {
			user.setMusic(FileUtils.readFileToByteArray(new File("E:/developsoftware/workspace/hibernateworkspace/hibernate2_association/bin/come and back.png")));
		} catch (IOException e) {
		}
		session.save(user);
		tran.commit();
	}

	@Test
	public void add1() {
		Session session = HibernateUtil.getSession();
		Transaction tran = session.beginTransaction();
		tran.begin();
		User user = new User();
		user.setName("lisi");
		user.setAddress("shanghai");
		user.setAge(18);
		session.save(user);
		tran.commit();
	}

	
	@Test
	public void readFile(){
		Session session = HibernateUtil.getSession();
		Transaction tran = session.beginTransaction();
		tran.begin();
		User user =(User)session.get(User.class, 4);
		try {
			FileUtils.writeByteArrayToFile(new File("d://test.png"),  user.getMusic());
		} catch (IOException e) {
			e.printStackTrace();
		}
		tran.commit();
	}
	@Test
	public void getFileResource() {
		System.out.println(User.class.getResource("/come and back.png")
				.getPath().substring(1));
	}
	
}
