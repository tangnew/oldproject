package com.jiawen.tong.bean.main;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.jiawen.tong.bean.Student;

public class Main0 {

	private static void sortStudentList(List<Student> students) {
		students.sort((a, b) -> {
			return a.getId() - b.getId();
		});
	}

	private static List<Student> sortStudentList(List<Student> list,
			Predicate<Student> per) {

		List<Student> students = new ArrayList<>();
		for (Student temp : list) {
			if (per.test(temp)) {
				students.add(temp);
			}
		}
		return students;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Student s1 = new Student(1, "1");
		Student s2 = new Student(2, "2");
		Student s3 = new Student(3, "3");
		Student s4 = new Student(4, "4");
		Student s5 = new Student(4, "5");
		
		List<Student> list = new ArrayList<Student>();
		list.add(s2);
		list.add(s1);
		list.add(s4);
		list.add(s3);
		list.add(s5);
		List<Student> flist = list.stream().filter((a)->{return true;}).collect(Collectors.toList());

		List<String> names = list.stream().map(Student::getName)
				.filter((a) -> {
					return !a.equals("1");
				}).distinct().limit(5).collect(Collectors.toList());
		names.stream().forEach((a) -> {
			System.out.println(a);
		});
		

		list.stream().forEach((a) -> {
			System.out.println(a.getId() + ";" + a.getName());
		});
		System.out.println("=======after sort=========");
		list = sortStudentList(list, new Predicate<Student>() {
			@Override
			public boolean test(Student t) {
				if (t.getId() > 2) {
					return true;
				}
				return false;
			}
		});
		// sortStudentList(list);
		list.stream().forEach((a) -> {
			System.out.println(a.getId() + ";" + a.getName());
		});
	}

}
