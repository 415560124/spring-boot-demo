package com.rhy.Zookeeper;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sun.rmi.runtime.Log;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Logger;

@Configuration
public class ZookeeperConfig {
    /**
     * 服务器集群配置
     */
    private static final String CONNECTION_STRING =
            "192.168.101.21:2181," +
            "192.168.101.22:2181," +
            "192.168.101.23:2181";
    /**
     * 超时时间
     */
    private  static final int SESSION_TIMEOUT = 2000;
    /**
     * countDownLatch这个类使一个线程等待其他线程各自执行完毕后再执行。
     * 是通过一个计数器来实现的，计数器的初始值是线程的数量。每当一个线程执行完毕后，计数器的值就-1，当计数器的值为0时，表示所有线程都执行完毕，然后在闭锁上等待的线程就可以恢复工作了。
     *
     */
    private static CountDownLatch latch= new CountDownLatch(1);
    /**
     * 日志
     */
    public static final Logger logger = Logger.getLogger(ZookeeperConfig.class.toString());

    @Bean
    public ZooKeeper init() throws InterruptedException {
        ZooKeeper zooKeeper = null;
        try {
            zooKeeper = new ZooKeeper(CONNECTION_STRING, SESSION_TIMEOUT, new Watcher() {
                @Override
                public void process(WatchedEvent watchedEvent) {
                    logger.info(watchedEvent.getState().toString());
                    logger.info(Event.KeeperState.SyncConnected.toString());
                    if(watchedEvent.getState() == Event.KeeperState.SyncConnected){
                        //将count值减1
                        logger.info("Zookeeper加载成功");
                        latch.countDown();
                    }
                }
            });
        } catch (IOException e) {
            logger.info("Zookeeper加载出错");
            e.printStackTrace();
        }
        //调用await()方法的线程会被挂起，它会等待直到count值为0才继续执行
        latch.await();
        return zooKeeper;
    }
}
