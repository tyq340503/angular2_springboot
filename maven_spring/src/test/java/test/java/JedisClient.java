package test.java;

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
		String result = jedis.get(key);
		redis.close();
		// TODO Auto-generated method stub
		return result;
	}

}
