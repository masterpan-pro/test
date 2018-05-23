package com.demo.util;

import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

/**
 * 工具bean，作用是在启动容器的时候利用spring将JedisConnectionFactory注入到RedisCache
 */
public class RedisCacheTransfer {

    public RedisCacheTransfer(JedisConnectionFactory jedisConnectionFactory) {
        RedisCache.setJedisConnectionFactory(jedisConnectionFactory);
    }
}
