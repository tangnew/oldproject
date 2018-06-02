/**
 * 
 */
package com.jw.job;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Jianjun Tang
 *
 * 2017年11月11日 下午9:37:10
 * 
 */
public class Apple {

	private ReentrantLock lock = new ReentrantLock();

	public void who(String name) {
		lock.lock();
		System.out.println(name + " is eating the apple!");
		lock.unlock();
	}
}
