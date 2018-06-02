package com.exam.dao;

import com.exam.entity.Teacher;
import java.util.List;

public interface TeacherMapper {
    int deleteByPrimaryKey(String id);

    int insert(Teacher record);

    Teacher selectByPrimaryKey(String id);

    List<Teacher> selectAll();

    int updateByPrimaryKey(Teacher record);
}