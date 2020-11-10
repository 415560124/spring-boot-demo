package com.rhy.Redis.Mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties.*;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: Herion_Rhy
 * @Date: 2019/7/17
 * @Description: 操作Redis字符串
 * @Version:1.0
 */
@Component
public class StringMapper {
    /**
     * 采用了JDK序列化器，所以在Redis服务器中它不是整数
     * 而是一个被JDK序列化器序列化后的二进制字符串
     * 不能使用Redis命令进行运算
     */
    @Autowired
    private RedisTemplate redisTemplate;
    /**
     * 此对象可以运算
     */
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    public Map<String,Object> testString(){
        Map<String,Object> res = new HashMap<>();
        redisTemplate.opsForValue().set("key1","value1");
        //注意这里使用了JDK的序列化器，所以Redis保存时不是整数，不能运算
        redisTemplate.opsForValue().set("int_key","1");
        stringRedisTemplate.opsForValue().set("int","1");
        //使用运算
        BoundValueOperations valueOperations = redisTemplate.boundValueOps("dou");
        valueOperations.increment(6.5);
        valueOperations.decrement(5);
        stringRedisTemplate.opsForValue().increment("int");
        stringRedisTemplate.opsForValue().increment("int");
        stringRedisTemplate.opsForValue().decrement("int");
        //获得底层Jedis连接
        //减1操作，这个命令RedisTemplate不支持,所以我先获得底层的连接再操作  ----------------  jedis没有decr方法 可能是版本高了 修改了
        //Jedis jedis = (Jedis) stringRedisTemplate.getConnectionFactory().getConnection().getNativeConnection();
        //jedis.decr("int");
        Object key1 = redisTemplate.opsForValue().get("key1");
        Object int_key = redisTemplate.opsForValue().get("int_key");
        Object intk = stringRedisTemplate.opsForValue().get("int");
        res.put("key1",key1);
        res.put("int_key",int_key);
        res.put("int",intk);
        return res;
    }
}
