package com.tjj.dao.impl;

import com.tjj.dao.AbstractDao;
import com.tjj.dao.TeacherDao;
import com.tjj.model.Teacher;

public class TeacherDaoImpl extends AbstractDao<Teacher> implements TeacherDao {

	@Override
	public void addTeacher(Teacher t) {
		super.save(t);
	}

	@Override
	public Teacher findTeacherById(Integer id) {
		return super.get(Teacher.class, id);
	}

	
}
