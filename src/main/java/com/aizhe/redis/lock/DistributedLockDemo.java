package com.aizhe.redis.lock;

import redis.clients.jedis.Jedis;

/**
 * @ClassName DistributedLockDemo
 * @Description TODO
 * @Author wangjiaming
 * @Date 2021/3/28 15:27
 */
public class DistributedLockDemo {


    public static void main(String[] args) {
        Jedis jedis = new Jedis("221.12.172.57", 26379);
        jedis.auth("Longshine@01");
        jedis.select(3);
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                buy(jedis);
            }, "线程"+ i).start();
        }
        jedis.close();

    }

    public static void buy(Jedis jedis){
        try {
            Long lock = jedis.setnx("lock", "1");
            jedis.expire("lock", 10);
            if(lock == 1){
                long stock = jedis.decr("stock");
                System.out.println(Thread.currentThread().getName() + "购买，剩余：" + stock);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //释放锁
            jedis.del("lock");
        }
    }

}
