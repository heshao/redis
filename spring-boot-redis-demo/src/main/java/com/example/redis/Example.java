package com.example.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.stream.StreamRecords;
import org.springframework.data.redis.connection.stream.StringRecord;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.TimeUnit;

@Component
public class Example {


    @Autowired
    private StringRedisTemplate redisTemplate;

    public void set(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public long add(String key, String value) {
        return redisTemplate.opsForSet().add(key, value);
    }

    public boolean add(String key, String value, double score) {
        return redisTemplate.opsForZSet().add(key, value, score);
    }

    public long push(String key, String value) {
        return redisTemplate.opsForList().leftPush(key, value);
    }

    public void put(String key, Map<?, ?> value) {
        redisTemplate.opsForHash().putAll(key, value);
    }

    public void expire(String key, long timeout, TimeUnit unit) {
        redisTemplate.expire(key, timeout, unit);
    }

}
