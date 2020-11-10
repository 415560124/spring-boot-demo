package com.rhy.Redis;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCache;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.time.Duration;

/**
 * @Auther: Herion_Rhy
 * @Date: 2019/7/17
 * @Description: 初始化Redis  主要把key改为使用字符串解析器
 * @Version:1.0
 */
@Configuration
public class RedisApplication {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private RedisConnectionFactory connectionFactory;
    //定义自定义初始化方法
    @PostConstruct  //拦截app的生命周期
    public void init(){
        initRedisTemplate();
    }
    //设置RedisTemplate的序列化器
    private void initRedisTemplate(){
        //字符串解析器
        RedisSerializer redisSerializer = redisTemplate.getStringSerializer();
        //key 字符串解析器
        redisTemplate.setKeySerializer(redisSerializer);
        ///value  字符串解析器 （可以解决订阅发送乱码问题）
        redisTemplate.setValueSerializer(redisSerializer);
        //hash key 字符串解析器
        redisTemplate.setHashKeySerializer(redisSerializer);

    }

    @Bean
    public RedisCacheManager redisCacheManager(){
        //Redis加锁的写入器
        RedisCacheWriter writer = RedisCacheWriter.lockingRedisCacheWriter(connectionFactory);
        //启动Redis缓存默认设置
        RedisCacheConfiguration cacheConfiguration = RedisCacheConfiguration.defaultCacheConfig();
        //设置序列化器
        //设置为JSON
        Jackson2JsonRedisSerializer serializer = new Jackson2JsonRedisSerializer(Object.class);
        //解决查询缓存转换异常的问题
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        serializer.setObjectMapper(om);
        //设置为JDK序列化器
        JdkSerializationRedisSerializer jdkSerializationRedisSerializer = new JdkSerializationRedisSerializer();
        cacheConfiguration = cacheConfiguration.serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(serializer));
        //禁用前缀
        cacheConfiguration = cacheConfiguration.disableKeyPrefix();
        //设置10min超市
        cacheConfiguration = cacheConfiguration.entryTtl(Duration.ofMinutes(10));
        //创建缓存管理器
        RedisCacheManager redisCacheManager = new RedisCacheManager(writer,cacheConfiguration);
        return redisCacheManager;
    }

}
