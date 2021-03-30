package com.aizhe.redis;

/**
 * @ClassName JedisFactory
 * @Description TODO
 * @Author wangjiaming
 * @Date 2021/3/28 16:00
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnection;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;
import redis.clients.jedis.Jedis;

import java.lang.reflect.Field;

/**
 * Jedis工厂类（单例模式）
 */
@Service
public class JedisFactory {
    @Autowired
    private RedisConnectionFactory connectionFactory;

    private JedisFactory(){}

    private static Jedis jedis;
    /**
     *  获得jedis对象
     */
    public Jedis getJedis() {
        //从RedisConnectionFactory中获取Redis连接(JedisConnection实现类),然后使用反射的方法从中取得了Jedis实例
        if(jedis == null){
            Field jedisField = ReflectionUtils.findField(JedisConnection.class, "jedis");
            ReflectionUtils.makeAccessible(jedisField);
            jedis = (Jedis) ReflectionUtils.getField(jedisField, connectionFactory.getConnection());
        }
        return jedis;
    }
}
