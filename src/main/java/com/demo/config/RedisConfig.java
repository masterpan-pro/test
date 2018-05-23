package com.demo.config;

import com.demo.util.RedisCacheTransfer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
@PropertySource({"classpath:redis.properties"})
public class RedisConfig {

    @Value("${redis.pool.minIdle}")
    private Integer minIdle;
    @Value("${redis.pool.maxIdle}")
    private Integer maxIdle;
    @Value("${redis.pool.maxActive}")
    private Integer maxActive;
    @Value("${redis.pool.maxWait}")
    private Long maxWait;
    @Value("${redis.pool.testOnBorrow}")
    private boolean testOnBorrow;

    @Value("${redis.host}")
    private String host;
    @Value("${redis.port}")
    private Integer port;
    @Value("${redis.password}")
    private String password;

    @Bean
    public JedisPoolConfig poolConfig() {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMinIdle(minIdle);
        poolConfig.setMaxIdle(maxIdle);
        poolConfig.setMaxTotal(maxActive);
        poolConfig.setMaxWaitMillis(maxWait);
        poolConfig.setTestOnBorrow(testOnBorrow);
        return poolConfig;
    }

    @Bean
    public JedisConnectionFactory jedisConnectionFactory(JedisPoolConfig poolConfig) {
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
        jedisConnectionFactory.setHostName(host);
        jedisConnectionFactory.setPort(port);
        jedisConnectionFactory.setPassword(password);
        jedisConnectionFactory.setUsePool(true);
        jedisConnectionFactory.setPoolConfig(poolConfig);
        return jedisConnectionFactory;
    }

    @Bean
    public RedisCacheTransfer redisCacheTransfer(JedisConnectionFactory jedisConnectionFactory) {
        return new RedisCacheTransfer(jedisConnectionFactory);
    }
}
