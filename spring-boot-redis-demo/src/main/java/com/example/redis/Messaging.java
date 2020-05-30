package com.example.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class Messaging {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public void send() {
        redisTemplate.convertAndSend("hello", "word");
    }

    public void receive(String message) {
        System.out.println(message);
    }
}
