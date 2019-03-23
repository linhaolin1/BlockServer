package com.lin.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisManager {
	JedisPool jedis;

	public RedisManager(String host, int port, String pass) {
		JedisPoolConfig poolConfig = new JedisPoolConfig();
		poolConfig.setMaxTotal(100);
		poolConfig.setMaxIdle(20);
		poolConfig.setTestOnBorrow(true);
		poolConfig.setTestOnReturn(true);
		jedis = new JedisPool(poolConfig, host, port, 1000, pass);
	}

	public Jedis getJedis() {
		return jedis.getResource();
	}

	public void set() {

	}

	public Long incr(String key) {
		Jedis client = getJedis();
		long num = client.incr(key);
		client.close();
		return num;
	}

	public void setex(byte[] key, int seconds, byte[] value) {
		Jedis client = getJedis();
		client.setex(key, seconds, value);
		client.close();
	}

	public byte[] get(byte[] key) {
		Jedis client = getJedis();
		byte[] bytes = client.get(key);
		client.close();
		return bytes;
	}

	public void del(String key) {
		Jedis client = getJedis();
		client.del(key);
		client.close();
	}

	public void del(byte[] key) {
		Jedis client = getJedis();
		client.del(key);
		client.close();
	}

}
