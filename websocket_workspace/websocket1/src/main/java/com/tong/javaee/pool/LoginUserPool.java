package com.tong.javaee.pool;

import com.tong.bean.Teacher;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by IDEA.
 * User: tjj.
 * Date : 2015/1/11
 * Time : 21:15
 */
public class LoginUserPool {
    /**
     * key为教师的id,value为登陆教师的不同客户端
     */
    private final static Map<String, Set<Teacher>> storage = new
            HashMap<>();
}
