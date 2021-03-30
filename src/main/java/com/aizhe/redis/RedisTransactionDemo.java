package com.aizhe.redis;

import com.alibaba.fastjson.JSONObject;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import java.util.Set;

/**
 * @ClassName RedisDemo
 * @Description TODO
 * @Author wangjiaming
 * @Date 2021/3/28 14:22
 */
public class RedisTransactionDemo {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("221.12.172.57", 26379);
        jedis.auth("Longshine@01");
        jedis.select(3);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("hello", "world");
        jsonObject.put("name", "lisi");
        Transaction multi = jedis.multi();
        String result = jsonObject.toJSONString();

        try {
            multi.set("user1", result);
            multi.set("user2", result);
            int a = 1/0;
            multi.exec();
        } catch (Exception e) {
            multi.discard();
            e.printStackTrace();
        } finally {
            System.out.println(jedis.get("user1"));
            System.out.println(jedis.get("user2"));
            jedis.close();
        }
    }

}
