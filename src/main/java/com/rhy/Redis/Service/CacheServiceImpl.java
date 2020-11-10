package com.rhy.Redis.Service;

import com.rhy.Redis.Mapper.CacheMapper;
import com.rhy.entity.admin.Rule;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CacheServiceImpl {
    @Autowired
    CacheMapper cacheMapper;

    //获取单个角色

    /**
     * Cacheable 表示先从缓存中查找 key ，如果有直接返回，否则执行方法，并且将返回结果保存到缓存中
     */
    @Cacheable(value="redisCache" , key="'redis_rule_'+#rId" ,condition = "#result != 'null'")
    public Rule getRule(int rId){
        Rule rule = cacheMapper.getRule(rId);
        System.out.println(rule);
        return rule;
    }

    //保存角色
    /**
     * CachePut表示将方法结果返回存放到缓存中。
     * value : 引用对应的缓存
     * key : 对应的缓存键
     */
    @CachePut(value = "redisCache", key="'redis_rule_'+#result.rId")
    @Transactional
    public Rule insertRule(Rule rule){
        cacheMapper.insertRule(rule);
        return rule;
    }

    //修改角色
    /**
     * CachePut表示将方法结果返回存放到缓存中。
     * condition : Spring EL表达式，这个表达式要求返回Boolean类型，如果为true则使用缓存操作
     */
    @CachePut(value = "redisCache" , key = "'redis_rule_'+#rId" , condition = "#result != 'null'")
    @Transactional
    public Rule updateRule(Rule rule){
        if(cacheMapper.updateRule(rule) != 0){
            return rule;
        }
        return null;
    }

    //查询角色列表
    public List<Rule> findRule(@Param("rId") int rId, @Param("rName") String rName){
        return cacheMapper.findRule(rId,rName);
    }

    //删除角色
    /**
     * CacheEvict ： 通过定义的键移除缓存
     * beforeInvocation：表示在方法执行之前移除缓存还是在方法执行之后。默认值为 false
     */
    @CacheEvict(value = "redisCache" , key= "'redis_rule_'+#rId" , beforeInvocation = false , condition = "#result != 0")
    @Transactional
    public int deleteRule(int rId){
        return cacheMapper.deleteRule(rId);
    }
}
