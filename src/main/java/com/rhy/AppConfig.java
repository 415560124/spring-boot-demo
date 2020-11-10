package com.rhy;

import com.rhy.Interceptor.AdminsInterceptor;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Auther: Herion_Rhy
 * @Date: 2019/7/17
 * @Description: 自定义初始化类
 * 可以设置@Bean，使return的类加入bean容器中
 * @Version:1.0
 */
@Configuration
public class AppConfig{
    public AppConfig(){
        System.out.println("AppConfig容器启动初始化。。。");
    }


}
