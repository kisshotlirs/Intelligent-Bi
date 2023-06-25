package com.mojo.bi.manager;

import com.mojo.bi.common.ErrorCode;
import com.mojo.bi.exception.ThrowUtils;
import org.redisson.Redisson;
import org.redisson.api.RRateLimiter;
import org.redisson.api.RateIntervalUnit;
import org.redisson.api.RateType;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author mojo
 * @description: 提供redis限流基础服务的
 * @date 2023/6/25 0025 22:07
 */
@Service
public class RedisLimitManger {

    @Resource
    private RedissonClient redissonClient;

    /**
     * 限流操作
     * @param key 区分不同的限流器
     */
    public void doRateLimit(String key) {
        // 创建一个每秒钟最多允许5个操作的RateLimiter
        RRateLimiter rateLimiter = redissonClient.getRateLimiter(key);
        rateLimiter.trySetRate(RateType.OVERALL, 2, 1 , RateIntervalUnit.SECONDS);

        //每当一个操作来了之后，请求一个令牌
        boolean isOp = rateLimiter.tryAcquire(1);
        ThrowUtils.throwIf(!isOp , ErrorCode.TOO_MANY_REQUEST);

        // 模拟多个用户进行操作
        for (int i = 0; i < 10; i++) {
            // 尝试获取一个许可证
            boolean acquired = rateLimiter.tryAcquire();
            if (acquired) {
                // 许可证获取成功，执行业务逻辑
                System.out.println("用户访问成功");
            } else {
                // 许可证获取失败，限制用户访问
                System.out.println("用户访问超过限制");
            }

            // 模拟用户每秒钟进行一次操作
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // 关闭Redisson客户端连接
        redissonClient.shutdown();
    }
}
