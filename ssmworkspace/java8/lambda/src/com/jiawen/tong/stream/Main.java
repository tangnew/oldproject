package com.jiawen.tong.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
	private void add(String obj) {
	}

	// private void add(Object obj){}
	private String add(String obj, String o) {
		return null;
	}

	public static void main(String[] args) {
		// filter();
		// flatMap();
		// reduce();
		threadRun();
	}

	private static void filter() {
		List<String> list = new ArrayList<>();
		list.add("str");
		list.add("test");
		Long size = list.stream().count();
		System.out.println("size=" + size);

		size = list.stream().filter((x) -> {
			return x.contains("str");
		}).count();
		System.out.println("size=" + size);
		size = list.stream().filter(x -> x.contains("a")).count();
		System.out.println("size=" + size);

		List<String> results = list.stream().filter(x -> x.contains("str"))
				.map(x -> x.toUpperCase()).collect(Collectors.toList());
		System.out.println("result=" + results);
	}

	private static void flatMap() {
		List<Integer> together = Stream
				.of(Arrays.asList(1, 2), Arrays.asList(3, 4))
				.flatMap(numbers -> numbers.stream())
				.collect(Collectors.toList());
		System.out.println("result=" + together);

		Integer min = together.stream().min(Comparator.comparing(x -> x)).get();
		System.out.println("result min=" + min);
	}

	private static void reduce() {
		int count = Stream.of(1, 2, 3, 4).reduce(0, (acc, e) -> acc + e);
		System.out.println("reduce=" + count);

	}

	private static void threadRun() {
		Runnable run = () -> {
			System.out.println("start");
		};

		Thread t = new Thread(run);
		t.start();
	}
}
