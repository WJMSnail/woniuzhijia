package com.aizhe;

import org.redisson.Redisson;
import org.redisson.config.Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @ClassName DemoApplication
 * @Description TODO
 * @Author wangjiaming
 * @Date 2021/3/28 17:14
 */
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public Redisson redisson(){
        Config config = new Config();
//        config.setLockWatchdogTimeout(9000);
        config.useSingleServer().setAddress("redis://221.12.172.57:26379")
                .setDatabase(3)
                .setPassword("Longshine@01")
                .setPingConnectionInterval(1000);
        return (Redisson) Redisson.create(config);
    }


}
