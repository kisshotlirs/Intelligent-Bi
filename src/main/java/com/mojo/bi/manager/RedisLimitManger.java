package com.mojo.bi.manager;

import com.mojo.bi.common.ErrorCode;
import com.mojo.bi.exception.ThrowUtils;
import org.redisson.api.RRateLimiter;
import org.redisson.api.RateIntervalUnit;
import org.redisson.api.RateType;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author mojo
 * @description: 提供redis限流基础服务的 令牌桶算法限流
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
    }
}
