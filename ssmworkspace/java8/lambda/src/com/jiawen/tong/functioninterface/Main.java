package com.jiawen.tong.functioninterface;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
	public static void main(String[] args) {
		Predicate<Long> p = (x) -> x > 5;
		boolean isResult = p.test(12L);
		System.out.println("Predicate resulst=" + isResult);

		p = (x) -> x < 3;
		isResult = p.test(12L);
		System.out.println("Predicate resulst=" + isResult);

		Supplier<Long> supplier = () -> {
			return 1112L;
		};
		Long lS = supplier.get();
		System.out.println("Supplier resulst=" + lS);

		Consumer<String> consumer = (x) -> {
			System.out.println("Consumer result=" + x);
		};
		Consumer<String> afterConsumer = (x) -> {
			System.out.println("Consumer result=" + x);
		};
		Consumer<String> afterConsumer1 = consumer.andThen(afterConsumer);
		afterConsumer1.accept("testqqq");

		Function<String, Long> function = (String x) -> {
			System.out.println("apply=" + x);
			return 21L;
		};
		Long functionResult = function.apply("jiawen");
		System.out.println("Function result=" + functionResult);
	}
}
