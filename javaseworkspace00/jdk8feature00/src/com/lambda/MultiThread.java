package com.lambda;

import java.util.Random;

public class MultiThread {
	public static void main(String[] args) {
//		Runnable r = () -> {
//			for (int i = 0; i < 100; i++) {
//				System.out.println("thread: num = " + i);
//			}
//		};
//
//		Thread d = new Thread(r);
//		d.start();
//		d = new Thread(() -> {
//			for (int i = 0; i < 100; i++) {
//				System.out.println("thread thread: num = " + i);
//			}
//		});
//		d.start();

		Random randow = new Random();
		long a = randow.ints().asLongStream().count();
		System.out.println("a===" + a);
	}
}
