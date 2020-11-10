package com.rhy.Redis;

import org.springframework.stereotype.Component;

/**
 * 监听器
 */
@Component
public class RedisMessageListener{
    /**
     * 处理方式1
     * @param message 监听消息
     */
    public void onMessage1(String message) {
        System.out.println("==================Redis订阅=================");
        //接收的消息
        System.out.println("Listener1:"+message);
        System.out.println("==================Redis订阅结束===============");
    }
    /**
     * 处理方式2
     * @param message 监听消息
     */
    public void onMessage2(String message) {
        System.out.println("==================Redis订阅=================");
        //接收的消息
        System.out.println("Listener2:"+message);
        System.out.println("==================Redis订阅结束===============");
    }
}
