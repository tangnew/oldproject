package com.tjj.dao;

import com.tjj.model.Teacher;

public interface TeacherDao {

	public void addTeacher(Teacher t);
	
	public Teacher findTeacherById(Integer id);
}
