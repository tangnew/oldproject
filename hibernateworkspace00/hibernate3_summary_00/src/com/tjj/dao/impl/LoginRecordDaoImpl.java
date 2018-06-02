package com.tjj.dao.impl;

import com.tjj.bean.LoginRecord;
import com.tjj.dao.HibernateDao;
import com.tjj.dao.LoginRecordDao;

public class LoginRecordDaoImpl extends HibernateDao<LoginRecord> implements
		LoginRecordDao {

	@Override
	public void saveLoginRecord(LoginRecord lr) {
		save(lr);
	}

}
