package com.aizhe.redis;

import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * @ClassName RedisDemo
 * @Description TODO
 * @Author wangjiaming
 * @Date 2021/3/28 14:22
 */
public class RedisDemo {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("221.12.172.57", 26379);
        jedis.auth("Longshine@01");
        String ping = jedis.ping();
        System.out.println(ping);
        jedis.select(3);
        Set<String> keys = jedis.keys("*");
        System.out.println(keys);
        String set = jedis.set("name", "zhangsan");
        String set1 = jedis.set("name", "zhangsan");
        jedis.set("age", "1");
        System.out.println(set);
        System.out.println(set1);
        String name = jedis.get("name");
        String age = jedis.get("age");
        Long age1 = jedis.incr("age");
        String age2 = jedis.get("age");
        System.out.println(name);
        System.out.println(age);
        System.out.println(age1);
        System.out.println(age2);
    }

}
