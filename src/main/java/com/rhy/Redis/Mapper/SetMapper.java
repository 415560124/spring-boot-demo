package com.rhy.Redis.Mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundSetOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
@Component
public class SetMapper {
    @Autowired
    RedisTemplate redisTemplate;
    public Map<String,Object> testSet(){
        Map<String,Object> res = new HashMap<>();
        //绑定set集合
        BoundSetOperations setOperations = redisTemplate.boundSetOps("set1");
        //v1重复两次，集合不允许重复，只是插入5个
        setOperations.add("v1","v1","v3","v5","v7","v9");
        //直接操作集合
        redisTemplate.opsForSet().add("set2","v2","v4","v6","v8","v10");
        //增加两个元素
        setOperations.add("v10","v7");
        //删除两个元素
        setOperations.remove("v1","v7");
        //返回所有元素
        Set set = setOperations.members();
        res.put("set1",set);
        //求成员数
        long size = setOperations.size();
        //求交集
        Set inter = setOperations.intersect("set2");
        res.put("inter",inter);
        //求差集
        Set diff = setOperations.diff("set2");
        res.put("dif",diff);
        //求并集
        setOperations.unionAndStore("set2","union");
        Set union = redisTemplate.opsForSet().members("union");
        res.put("union",union);
        return res;
    }
}
