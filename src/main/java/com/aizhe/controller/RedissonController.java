package com.aizhe.controller;

import org.redisson.Redisson;
import org.redisson.RedissonLock;
import org.redisson.api.RLock;
import org.redisson.command.CommandAsyncExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Time;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName DistributedLockController
 * @Description TODO
 * @Author wangjiaming
 * @Date 2021/3/28 15:58
 */
@RestController
public class RedissonController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private Redisson redisson;


    @RequestMapping(value = "/deduct_stock2", method = RequestMethod.GET)
    public String deductStock(){
        String lockKey = "product_id";
        RLock lock = redisson.getLock(lockKey);
        try {
            //同一时刻只有一个线程会拿到锁，其他线程阻塞
            lock.lock();
            int stock = Integer.parseInt(stringRedisTemplate.opsForValue().get("stock"));
            TimeUnit.SECONDS.sleep(20);
            if(stock > 0){
                int realStock = stock - 1;
                stringRedisTemplate.opsForValue().set("stock", realStock + "");
                System.out.println("扣减成功，剩余库存："+ realStock);
            }else{
                System.out.println("库存不足");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//            if(lock.isLocked() && lock.isHeldByCurrentThread()){
//                lock.unlock();
//            }
            if(Thread.currentThread().isInterrupted()){
                lock.unlock();
            }
        }
        return "end";
    }


}
