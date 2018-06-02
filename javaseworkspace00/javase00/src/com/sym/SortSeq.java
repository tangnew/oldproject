package com.sym;

public class SortSeq {

	/**
	 * 将数组进行排序.输入的数组car不能够为null并且大小不能够为0.
	 * 
	 * @param cars
	 * @return 返回进行了多少次的循环
	 */
	private static int sortCars(Car[] cars) {
		if (null == cars || 0 == cars.length) {
			throw new RuntimeException(
					"The array of cars is null or the size of cars is 0!");
		}

		int maxNumber = cars.length;
		int times = 0;
		for (int i = 0; i < cars.length;) {
			Car car = cars[i];
			// Car对象不能够为null -s
			if (null == car) {
				throw new RuntimeException(
						"The object of car must not be null!");
			}
			// Car对象不能够为null -e

			// Car对象的num值不能够小于0或者num值不能够大于数组的大小 -s
			if (0 > car.num || maxNumber < car.num) {
				throw new RuntimeException(
						"The num of car is not correct! The num of car must be between 0 and "
								+ maxNumber + "!");
			}
			// Car对象的num值不能够小于0或者num值不能够大于数组的大小 -e

			if (car.num == i) {// 说明Car对象的num与数组的下标值相等
				i++;
			} else {// 说明Car对象的num与数组的下标值不等,则进行交换
				int tempNum = car.num;
				cars[i] = cars[tempNum];
				cars[tempNum] = car;
			}
			times++;
		}
		return times;
	}

	/**
	 * 打印数组信息
	 * 
	 * @param cars
	 */
	private static void printCars(Car[] cars) {
		for (Car c : cars) {
			System.out.print(c.num + "\t");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Car[] cars = { new Car(1), new Car(4), new Car(2), new Car(3),
				new Car(0) };
		System.out.println("======before sort========");
		printCars(cars);

		int times = sortCars(cars);
		System.out.println("\n======after sort========");
		printCars(cars);
		System.out.println("total times:" + times);
	}
}

/**
 * 定义Car类
 * 
 */
class Car {
	int num;

	public Car(int num) {
		this.num = num;
	}
}