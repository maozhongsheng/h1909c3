package day10_redis;

import org.junit.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RediisrTest {
	@Test
	public void testJedis(){
		Jedis jedis = new Jedis("127.0.0.1",6379);
		jedis.set("name","毛哥最帅");
		String name = jedis.get("name");
		System.out.println(name);
		jedis.close();
	}
	@Test
	public void testJedisPool(){
		//jedis连接池属性配置
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxTotal(10);
		config.setMaxIdle(5);
		//实例化jedis连接池
		JedisPool jedisPool = new JedisPool(config,"127.0.0.1",6379);
		//获取链接
		Jedis jedis = jedisPool.getResource();
		
		jedis.set("name", "文杰最丑");
		
		jedis.close();
		jedisPool.close();
		
	}
}
