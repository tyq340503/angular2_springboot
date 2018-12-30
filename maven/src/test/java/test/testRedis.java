package test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class testRedis {
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
	
	@Test
	public void test3(){
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:app*.xml");
		Jedis jedis = (Jedis) context.getBean("jedis");
		String test = jedis.get("key1");
		System.err.println(test);
		jedis.close();
	}
	
	@Test
	public void test4(){
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:app*.xml");
		JedisInterface jedis =  context.getBean(JedisInterface.class);
		String test = jedis.get("key1");
		System.err.println(test);
		jedis.close();
	}
}
