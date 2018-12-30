package test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Component
public class JedisClient implements JedisInterface {
	@Autowired
	private JedisPool jedisPool;
	@Override
	public String get(String key) {
		Jedis jedis = jedisPool.getResource();
		jedis.auth("tyq340503");
		String result = jedis.get(key);
		jedis.close();
		// TODO Auto-generated method stub
		return result;
	}

}
