package com.rhy.Redis.Mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisZSetCommands;
import org.springframework.data.redis.core.BoundZSetOperations;
import org.springframework.data.redis.core.DefaultTypedTuple;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Component
public class ZSetMapper {
    @Autowired
    RedisTemplate redisTemplate;

    public Map<String,Object> testZSet(){
        Map<String,Object> res = new HashMap<>();
        //创建一个set存储即将添加的数据
        Set<ZSetOperations.TypedTuple<String>> set = new HashSet<>();
        for(double i=0;i<10;i++){
            //TypedTuple默认实现类DefaultTypedTuple
            ZSetOperations.TypedTuple<String> typedTuple = new DefaultTypedTuple<String>("value"+i,i);
            set.add(typedTuple);
        }
        //绑定Zset集合操作
        BoundZSetOperations zSetOperations = redisTemplate.boundZSetOps("zset1");
        //赋值
        zSetOperations.add(set);
        //添加一个元素
        zSetOperations.add("value11",5.6);
        //获取全部元素 无序 TypedTuple
        Set<String> setRange = zSetOperations.range(0,-1);
        res.put("setRange",set);
        //按分数排序获取有序集合
        Set<String> setRangeByScore = zSetOperations.rangeByScore(4,9);
        res.put("setRangeByScore",setRangeByScore);
        //定义值范围
        RedisZSetCommands.Range range = new RedisZSetCommands.Range();
        //大于 value3
        range.gt("value3.0");
        //大于等于
        //range.gte("value3");
        //小于
        //range.lt("value8");
        //小于等于
        range.lte("value8.0");
        //这个值是按照字符串排序
        Set<String> setLex = zSetOperations.rangeByLex(range);
        res.put("setLex",setLex);
        //删除元素
        zSetOperations.remove("value8","value9");
        //求分数
        Double score = zSetOperations.score("value11");
        //在下标区间内按分数排序 TypedTuple
        Set<ZSetOperations.TypedTuple<String>> rangeSet = zSetOperations.rangeWithScores(1,5);
        res.put("rangeSet",rangeSet);
        //在分数区间内按分数排序 TypedTuple
        Set<ZSetOperations.TypedTuple<String>> scoreSet = zSetOperations.rangeByScoreWithScores(5,10);
        res.put("scoreSet",scoreSet);
        //按从大到小排序
        Set<String> reverseSet = zSetOperations.reverseRange(0,-1);
        res.put("reverseSet",reverseSet);
        return res;
    }
}
