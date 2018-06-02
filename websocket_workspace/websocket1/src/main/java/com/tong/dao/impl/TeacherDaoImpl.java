package com.tong.dao.impl;

import com.tong.bean.Teacher;
import com.tong.bean.TeacherPool;
import com.tong.dao.TeacherDao;

/**
 * Created by IDEA.
 * User: tjj.
 * Date : 2015/1/11
 * Time : 18:52
 */
public class TeacherDaoImpl implements TeacherDao {

    @Override
    public Teacher getTeacherByName(String name) {
        return TeacherPool.getTeacherByName(name);
    }
}
