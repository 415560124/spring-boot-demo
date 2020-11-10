package com.rhy.Redis.Mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@Component
public class ListMapper {
    @Autowired
    RedisTemplate redisTemplate;

    /**
     * 测试操作
     * @return
     */
    public Map<String,Object> testList(){
        Map<String,Object> res = new HashMap<>();
        //链表从左到右顺序为 v10 v8 v6 v4 v2
        redisTemplate.opsForList().leftPushAll("list1","v2","v4","v6","v8","v10");
        //链表从左到右顺序为 v1 v3 v5 v7 v9 v10
        redisTemplate.opsForList().rightPushAll("list2","v1","v3","v5","v7","v9","v10");
        //绑定list1进行操作
        BoundListOperations listOperations = redisTemplate.boundListOps("list2");
        //从左边弹出一个元素 v1
        Object obj1 = listOperations.leftPop();
        res.put("obj1",obj1.toString());
        //获取定位元素，从0开始 v3
        Object obj2 = listOperations.index(1);
        res.put("obj2",obj2.toString());
        //从左边插入链表l
        listOperations.leftPush("v0");
        //求链表长度
        long size = listOperations.size();
        //求链表下标区间成员
        List<Object> list = listOperations.range(0,-1);
        res.put("list1",redisTemplate.opsForList().range("list1",0,redisTemplate.opsForList().size("list1")-1));
        res.put("list2",list);
        return res;
    }
}
