package com.tong.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by IDEA.
 * User: tjj.
 * Date : 2015/1/11
 * Time : 18:47
 */
public final class TeacherPool {
    private final static Map<String, Teacher> storage = new HashMap<>();

    static {
        Teacher t1 = new Teacher(UUID.randomUUID().toString(), "lisi1");
        Teacher t2 = new Teacher(UUID.randomUUID().toString(), "lisi2");
        Teacher t3 = new Teacher(UUID.randomUUID().toString(), "lisi3");
        storage.put(t1.getId(), t1);
        storage.put(t2.getId(), t2);
        storage.put(t3.getId(), t3);
    }

    public static Teacher getTeacherByName(String name) {
        Teacher teacher = null;
        for (Teacher t : storage.values()) {
            if (name.equals(t.getName())) {
                teacher = t;
                break;
            }
        }
        return teacher;
    }
}
