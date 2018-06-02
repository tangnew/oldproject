/**
 * 
 */
package com.jw.job;

/**
 * @author Jianjun Tang
 *
 *         2017年11月11日 下午9:38:32
 * 
 */
public class Client implements Runnable {

	private Apple apple;

	private String name;
	/**
	 * 
	 */
	public Client(String name, Apple apple) {
		this.apple = apple;
		this.name = name;
	}

	@Override
	public void run() {
		int i = 0;
		while(i < 100) {
			apple.who(name + (i++));
		}
	}

}
