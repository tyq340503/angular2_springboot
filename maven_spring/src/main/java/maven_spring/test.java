package maven_spring;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class test {
	public void test1(){
		Jedis jedis = new Jedis("10.0.116.151",6379);
		jedis.set("key1", "test1");
		jedis.close();
	}
	
	public void test2(){
		JedisPool jedis2 = new JedisPool("10.0.116.151",6379);
		Jedis jedis = jedis2.getResource();
		System.err.println(jedis.get("key1"));
		jedis.close();
		jedis2.close();
	}
}
