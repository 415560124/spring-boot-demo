package com.rhy.Redis;

//@Component
public class RedisMessageListener2 {
    //处理订阅
    public void messageDispose(String message){
        System.out.println(message);
    }
    //处理订阅
    public void messageDispose2(String message){
        System.out.println(message);
    }
}
