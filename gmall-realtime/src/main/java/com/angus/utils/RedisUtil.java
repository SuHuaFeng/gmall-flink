package com.angus.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
/**
 * @author ：Angus
 * @date ：Created in 2022/5/2 18:41
 * @description：
 */

public class RedisUtil {
    public static JedisPool jedisPool = null;
    public static Jedis getJedis() {
        if (jedisPool == null) {
            JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
            jedisPoolConfig.setMaxTotal(100); //最大可用连接数
            jedisPoolConfig.setBlockWhenExhausted(true); //连接耗尽是否等待
            jedisPoolConfig.setMaxWaitMillis(2000); //等待时间
            jedisPoolConfig.setMaxIdle(5); //最大闲置连接数
            jedisPoolConfig.setMinIdle(5); //最小闲置连接数
            jedisPoolConfig.setTestOnBorrow(true); //取连接的时候进行一下测试 ping
            jedisPool = new JedisPool(jedisPoolConfig, "hadoop1", 6379, 1000);
            return jedisPool.getResource();
        } else {
            return jedisPool.getResource();
        }
    }
}

