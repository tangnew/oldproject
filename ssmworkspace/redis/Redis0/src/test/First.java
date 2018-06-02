package test;

import redis.clients.jedis.Jedis;
import redis.clients.util.Pool;

public class First {

	public static void main(String[] args) {
		Jedis jedis = new Jedis("192.168.1.110",8000);
//		Pool<Jedis> jedisPool = new Pool<Jedis>();
//		jedis.setDataSource(jedisPool);
		jedis.set("doudou", "doudou");
		String value = jedis.get("doudou");
		System.out.println(value);
		value = jedis.get("laozi");
		System.out.println(value);
		jedis.set("laozi", "list test me me");
	}

}
