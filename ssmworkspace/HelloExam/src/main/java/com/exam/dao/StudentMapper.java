package com.exam.dao;

import com.exam.entity.Student;
import java.util.List;

public interface StudentMapper {
    int deleteByPrimaryKey(String id);

    int insert(Student record);

    Student selectByPrimaryKey(String id);

    List<Student> selectAll();

    int updateByPrimaryKey(Student record);
}