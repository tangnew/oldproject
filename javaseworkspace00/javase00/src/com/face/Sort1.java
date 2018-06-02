package com.face;

public class Sort1 {

	/*final int i;

	public Sort1(int i) {
		this.i = i;
	}

	public static void main(String[] args) {
		Car[] cars = { new Car(2), new Car(3), new Car(1), new Car(4),
				new Car(0) };
		System.out.println("======before sort========");
		for (int i = 0; i < cars.length; i++) {
			System.out.print(cars[i].num + "\t");
		}
		
		sortCars(cars);
		System.out.println("\n======after sort========");
		for (Car c : cars) {
			System.out.print(c.num + "\t");
		}
	}

	private static int sortCars(Car[] cars) {
		if (null == cars || 0 == cars.length) {
			throw new RuntimeException(
					"The array of cars is null or the size of cars is 0!");
		}

		int maxNumber = cars.length;

		int times = 0;
		for (int i = 0; i < cars.length;) {
			Car car = cars[i];
			if (null == car) {
				throw new RuntimeException(
						"The object of car must not be null!");
			}
			if (0 > car.num || maxNumber < car.num) {
				throw new RuntimeException(
						"The num of car is not correct! The num of car must be between 0 and "
								+ maxNumber + "!");
			}
			if (car.num == i) {
				i++;
				continue;
			} else {
				int tempNum = car.num;
				cars[i] = cars[tempNum];
				cars[tempNum] = car;
			}
			times++;
		}
		return times;
	}*/
}

//class Car {
//	int num;
//
//	public Car(int num) {
//		this.num = num;
//	}
//}