package com.factory0;

public class FlightFactory implements Factory {
	@Override
	public Moveable create() {
		return new Flight();
	}
}
