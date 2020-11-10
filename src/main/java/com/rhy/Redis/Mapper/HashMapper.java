package com.rhy.Redis.Mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: Herion_Rhy
 * @Date: 2019/7/17
 * @Description: 操作Redis  Hash
 * @Version:1.0
 */
@Component
public class HashMapper {
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
    public Map<String,Object> testHash(){
        Map<String,Object> res = new HashMap<>();

        Map<String,String> hash = new HashMap<>();
        hash.put("field1","value1");
        hash.put("field2","value2");

        //存入一个散列数据类型
        stringRedisTemplate.opsForHash().putAll("hash",hash);
        stringRedisTemplate.opsForHash().put("hash","field3","value3");
        //取值
        Object hashField1 = stringRedisTemplate.opsForHash().get("hash","field1");
        //绑定散列操作的key，这样可以连续对同一个散列数据类型进行操作
        BoundHashOperations hashOperations = stringRedisTemplate.boundHashOps("hash");
        hashOperations.put("field4","value4");
        hashOperations.delete("field3","value5");
        res.put("hash-field1",hashField1);
        return res;
    }
}
