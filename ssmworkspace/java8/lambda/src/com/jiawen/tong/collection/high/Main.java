package com.jiawen.tong.collection.high;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		high0();
	}

	public static void high0() {
		Student s0 = new Student(1, "lisi1", 1, 1, 1);
		Student s1 = new Student(2, "lisi2", 2, 1, 1);
		Student s2 = new Student(3, "lisi3", 3, 2, 1);
		Student s3 = new Student(4, "lisi4", 4, 2, 1);
		List<Student> students = Arrays.asList(s0, s1, s2, s3);

		Optional<Student> result = students.stream().collect(
				Collectors.minBy((a0, a1) -> {
					return a0.getAge() - a1.getAge();
				}));
		System.out.println("min=" + result.get().getAge());

		System.out.println("--------IntSummaryStatistics----------");
		IntSummaryStatistics iResult = students.stream()
				.mapToInt(s -> s.getAge()).summaryStatistics();
		System.out.println("min=" + iResult.getMin() + ",max="
				+ iResult.getMax() + ",avg=" + iResult.getAverage() + ",sum="
				+ iResult.getSum() + ",count=" + iResult.getCount());

		System.out.println("--------map----------");
		List<String> names = students.stream().map(s -> s.getName())
				.collect(Collectors.toList());
		System.out.println("names=" + names);

		System.out.println("--------reduce----------");
		Integer ages = students.stream().map(Student::getAge)
				.reduce(0, (acc, e) -> acc + e);
		System.out.println("ages=" + ages);

		System.out.println("--------sorted----------");
		List<Student> sorts = students.stream()
				.sorted(Comparator.comparing(s -> s.getAge()))
				.collect(Collectors.toList());
		System.out.println("sorts=" + sorts);

		System.out.println("--------groupingBy----------");
		Map<Integer, List<Student>> grouping = students.stream().collect(
				Collectors.groupingBy(s -> s.getAge()));
		System.out.println("groupingBy=" + grouping);

		System.out.println("--------partitioningBy----------");
		Map<Boolean, List<Student>> partitioning = students.stream().collect(
				Collectors.partitioningBy(s -> s.getGradeNo() > 1));
		System.out.println("partitioning=" + partitioning);

		System.out.println("--------toMap---------");
		Map<String, Student> toMap = students.stream().collect(
				Collectors.toMap(s -> s.getName(), s -> s));
		System.out.println("toMap=" + toMap);
	}
}
