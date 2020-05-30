package org.example;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void test1() {
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost", 6379);
        System.out.println("连接成功");
        //设置 redis 字符串数据
        jedis.set("runoobkey", "www.runoob.com");
        // 获取存储的数据并输出
        System.out.println("redis 存储的字符串为: " + jedis.get("runoobkey"));
    }

    @Test
    public void test2() {
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost");
        System.out.println("连接成功");
        //存储数据到列表中
        jedis.lpush("site-list", "Runoob");
        jedis.lpush("site-list", "Google");
        jedis.lpush("site-list", "Taobao");
        // 获取存储的数据并输出
        List<String> list = jedis.lrange("site-list", 0, 2);
        for (int i = 0; i < list.size(); i++) {
            System.out.println("列表项为: " + list.get(i));
        }
    }

    @Test
    public void test3() {
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost");
        System.out.println("连接成功");
        //存储数据到hash中
        jedis.hset("site-hash", "name", "heshao");
        jedis.hset("site-hash", "age", "18");
        // 获取存储的数据并输出
        Map<String, String> hash = jedis.hgetAll("site-hash");
        System.out.println("哈希项为: " + hash.toString());
    }

    @Test
    public void test4() {
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost");
        System.out.println("连接成功");
        //存储数据到set中
        jedis.sadd("site-set", "Runoob");
        jedis.sadd("site-set", "Google");
        jedis.sadd("site-set", "Taobao");
        jedis.sadd("site-set", "Taobao");
        // 获取存储的数据并输出
        Set<String> set = jedis.smembers("site-set");
        System.out.println("集合项为：" + set.toString());
    }

    @Test
    public void test5() {
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost");
        System.out.println("连接成功");
        //存储数据到zset中
        jedis.zadd("site-zset", 1, "Runoob");
        jedis.zadd("site-zset", 1, "Google");
        jedis.zadd("site-zset", 1, "Taobao");
        jedis.zadd("site-zset", 2, "Taobao");
        // 获取存储的数据并输出
        Set<String> set = jedis.zrevrange("site-zset", 0, 4);
        System.out.println("集合项为：" + set.toString());
    }

    @Test
    public void test6() {
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost");
        System.out.println("连接成功");
        //存储数据到zset中
        jedis.pfadd("site-pf", "Runoob");
        jedis.pfadd("site-pf", "Google");
        jedis.pfadd("site-pf", "Taobao");
        jedis.pfadd("site-pf", "Taobao");
        // 获取存储的数据并输出
        long count = jedis.pfcount("site-pf");
        System.out.println("基数为：" + count);
    }
}
