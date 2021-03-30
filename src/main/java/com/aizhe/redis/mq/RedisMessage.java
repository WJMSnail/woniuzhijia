package com.aizhe.redis.mq;

import lombok.Data;
import lombok.ToString;

/**
 * @ClassName RedisMessage
 * @Description TODO
 * @Author wangjiaming
 * @Date 2021/3/29 0:35
 */
@Data
@ToString
public class RedisMessage {

    private String id;

    private Object message;

}
