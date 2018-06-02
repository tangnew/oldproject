package com.generic;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import sun.reflect.misc.ReflectUtil;

public class MainO {
	public static void main(String[] args) {

		Student s = getObject(Student.class);
		System.out.println(s);
	}

	// <T> 跟编译器说这是泛型方法，这是语法规定的。T是函数的返回类型。
	public static <T> T getObject(Class<T> cls) {
		T o = null;
		try {
			o = cls.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
		Method[] ms = cls.getMethods();
		for (Method temp : ms) {
			if (temp.getName().startsWith("setName")) {
				temp.setAccessible(true);
				try {
					temp.invoke(o, "lisi");
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return o;
	}

	public <T> T getObjects(String name) {

		return null;
	}
}
