package com.army.building.dynamic;

public class Logging implements LoggingI {
	@Override
	public void start() {
		System.out.println("logging starting");
	}

	@Override
	public void end() {
		System.out.println("logging end");
	}
}
