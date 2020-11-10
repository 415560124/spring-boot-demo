package com.rhy.Redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

//@Configuration
public class MessageApplicationn2 {
    //处理监听的线程池
    private ThreadPoolTaskScheduler threadPoolTaskScheduler;
    @Bean
    public ThreadPoolTaskScheduler initThreadPool(){
        ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
        threadPoolTaskScheduler.setPoolSize(100);
        return threadPoolTaskScheduler;
    }
    //Redis连接工厂
    @Autowired
    private RedisConnectionFactory connectionFactory;
    @Bean
    public RedisMessageListenerContainer initMessageListenerContainer(MessageListenerAdapter dispose1,MessageListenerAdapter dispose2){
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setTaskExecutor(threadPoolTaskScheduler);
        container.setConnectionFactory(connectionFactory);
        container.addMessageListener(dispose1,new ChannelTopic("test1"));
        container.addMessageListener(dispose2,new ChannelTopic("test2"));
        return container;
    }
    //Redis消息监听容器
    @Autowired
    private RedisMessageListener2 listener2;
    @Bean
    public MessageListenerAdapter dispose1(){
        return new MessageListenerAdapter(listener2,"messageDispose");
    }
    @Bean
    public MessageListenerAdapter dispose2(){
        return new MessageListenerAdapter(listener2,"messageDispose2");
    }
}
