package com.tong.service.impl;

import com.tong.bean.Teacher;
import com.tong.dao.TeacherDao;
import com.tong.dao.impl.TeacherDaoImpl;
import com.tong.service.TeacherService;

/**
 * Created by IDEA.
 * User: tjj.
 * Date : 2015/1/11
 * Time : 18:54
 */
public class TeacherServiceImpl implements TeacherService {
    private TeacherDao teacherDao = new TeacherDaoImpl();

    @Override
    public Teacher getTeacherByName(String name) {
        return teacherDao.getTeacherByName(name);
    }
}
