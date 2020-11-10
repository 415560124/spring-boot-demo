package com.rhy.Redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

/**
 * 发布/订阅初始化
 */
@Configuration
public class MessageApplication {
    //Redis连接工厂
    @Autowired
    private RedisConnectionFactory connectionFactory;
    //Redis消息监听器
    @Autowired
    private RedisMessageListener messageListener;

    //任务池
    private ThreadPoolTaskScheduler taskScheduler;

    /**
     * 创建任务池
     * @return 创建的任务池
     */
    @Bean
    public ThreadPoolTaskScheduler iniTaskScheduler(){
        if(taskScheduler!=null){
            return taskScheduler;
        }
        taskScheduler = new ThreadPoolTaskScheduler();
        taskScheduler.setPoolSize(100);
        return taskScheduler;
    }
    /**
     * 创建Redis监听器容器
     */
    @Bean
    public RedisMessageListenerContainer initContainer(MessageListenerAdapter listenerAdapterTest1,MessageListenerAdapter listenerAdapterTest2){
        //创建监听器容器
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        //设置Redis连接工厂
        container.setConnectionFactory(connectionFactory);
        //设置容器连接池 运行时的任务执行程序
        container.setTaskExecutor(taskScheduler);
        //适配器监听频道1
        container.addMessageListener(listenerAdapterTest1,new ChannelTopic("test1"));
        //适配器监听频道2
        container.addMessageListener(listenerAdapterTest2,new ChannelTopic("test2"));
        return container;
    }

    /**
     * 消息监听适配器   利用反射技术（监听执行器的方法名）
     */
    @Bean
    public MessageListenerAdapter listenerAdapterTest1(){
        return new MessageListenerAdapter(messageListener,"onMessage1");
    }
    @Bean
    public MessageListenerAdapter listenerAdapterTest2(){
        return new MessageListenerAdapter(messageListener,"onMessage2");
    }
}
