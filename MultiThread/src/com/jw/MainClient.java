/**
 * 
 */
package com.jw;

import com.jw.job.Apple;
import com.jw.job.Client;

/**
 * @author Jianjun Tang
 *
 *         2017年11月11日 下午9:35:20
 * 
 */
public class MainClient {
	public static void main(String[] args) {
		Apple apple = new Apple();
		Runnable c0 = new Client("c0", apple);
		Runnable c1 = new Client("c1", apple);
		
		Thread ct0 = new Thread(c0);
		Thread ct1 = new Thread(c1);
		
		ct0.start();
		ct1.start();
	}
}
