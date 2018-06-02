package com.factory0;

public class CarFactory implements Factory {
	@Override
	public Moveable create() {
		return new Car();
	}

}
