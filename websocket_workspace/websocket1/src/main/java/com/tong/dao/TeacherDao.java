package com.tong.dao;

import com.tong.bean.Teacher;

/**
 * Created by IDEA.
 * User: tjj.
 * Date : 2015/1/11
 * Time : 18:51
 */
public interface TeacherDao {
    public Teacher getTeacherByName(String name);
}
