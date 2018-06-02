/**
 * 
 */
package com.redis.jedis.client;

import redis.clients.jedis.Jedis;

/**
 * @author TangJianjun
 *
 *         2015年9月13日 上午11:51:29
 */
public class Client {
	public static void main(String[] args) {

		Jedis jedis = new Jedis("192.168.1.110", 8000);
	//	jedis.set("name", "laozi");
		String value = jedis.get("name");
		System.out.println(value);
	}
}
