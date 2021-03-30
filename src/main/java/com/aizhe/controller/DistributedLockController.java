package com.aizhe.controller;

import com.aizhe.redis.lock.SurvivalClamProcessor;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Time;
import java.util.Collections;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName DistributedLockController
 * @Description TODO
 * @Author wangjiaming
 * @Date 2021/3/28 15:58
 */
@RestController
public class DistributedLockController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    @RequestMapping(value = "/deduct_stock", method = RequestMethod.GET)
    public String deductStock(){
        String lockField = "lockKey";
        String randomValue = UUID.randomUUID().toString();
        long lockTime = 10;
        try {
            Boolean result = stringRedisTemplate.opsForValue().setIfAbsent(lockField, randomValue, lockTime, TimeUnit.SECONDS);
//            RedisScript redisScript = RedisScript.of(script, Long.class);
//            Long result = stringRedisTemplate.execute(redisScript, Collections.singletonList(key), value, expireTime + "");
//            SurvivalClamProcessor survivalClamProcessor
//                    = new SurvivalClamProcessor(lockField, lockKey, randomValue, lockTime);
//            Thread survivalThread = new Thread(survivalClamProcessor);
//            survivalThread.setDaemon(Boolean.TRUE);
//            survivalThread.start();
//            Object returnObject = joinPoint.proceed(args);
//            survivalClamProcessor.stop();
//            survivalThread.interrupt();

            if(!result){
                return "error";
            }
            int stock = Integer.parseInt(stringRedisTemplate.opsForValue().get("stock"));
            TimeUnit.SECONDS.sleep(3);
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
            if(randomValue.equals(stringRedisTemplate.opsForValue().get(lockField))){
                stringRedisTemplate.delete(lockField);
            }
        }
        return "end";
    }



}
