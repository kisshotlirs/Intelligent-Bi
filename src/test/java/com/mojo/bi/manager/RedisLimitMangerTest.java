package com.mojo.bi.manager;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class RedisLimitMangerTest {

    @Resource
    private RedisLimitManger redisLimitManger;

    @Test
    void doRateLimit() {
        String userId = "1";
        for (int i = 0; i < 5; i++) {
            redisLimitManger.doRateLimit(userId);
            System.out.println("成功");
        }
    }

}