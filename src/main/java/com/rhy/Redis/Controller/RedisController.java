package com.rhy.Redis.Controller;

import com.rhy.Redis.Service.IRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: Herion_Rhy
 * @Date: 2019/7/17
 * @Description: com.rhy.Redis.Controller
 * @Version:1.0
 */
@RestController
@RequestMapping("/redis")
public class RedisController {
    @Autowired
    private IRedisService iRedisService;
    @Autowired
    private RedisTemplate redisTemplate;
    /**
     * String
     * 字符串测试
     * @return 测试结果
     */
    @RequestMapping("/stringMapper")
    public Map<String,Object> stringMapper(){
        Map<String,Object> res = iRedisService.stringMapper();
        return res;
    }
    /**
     * Hash
     * Hash测试
     * @return 测试结果
     */
    @RequestMapping("/hashMapper")
    public Map<String,Object> hashMapper(){
        Map<String,Object> res = iRedisService.hashMapper();
        return res;
    }
    /**
     * List
     * list测试
     * @return 测试结果
     */
    @RequestMapping("/listMapper")
    public Map<String,Object> listMapper(){
        Map<String,Object> res = iRedisService.listMapper();
        return res;
    }
    /**
     * Set
     * set测试
     * @return 测试结果
     */
    @RequestMapping("/SetMapper")
    public Map<String,Object> setMapper(){
        Map<String,Object> res = iRedisService.setMapper();
        return res;
    }
    /**
     * ZSet
     * set测试
     * @return 测试结果
     */
    @RequestMapping("/ZSetMapper")
    public Map<String,Object> zSetMapper(){
        Map<String,Object> res = iRedisService.zSetMapper();
        return res;
    }

    /**
     * 测试redis事务
     * @return
     */
    @RequestMapping("/Multi")
    public Map<String,Object> testMulti(){
        Map<String,Object> res = new HashMap<>();
        //设置一个测试value
        redisTemplate.opsForValue().set("key1","value1");
        List list = (List) redisTemplate.execute(new SessionCallback() {
            @Override
            public Object execute(RedisOperations operations) throws DataAccessException {
                //redis 事务： watch... multi... exec...
                //设置要监控的key
                operations.watch("key1");
                //开启事务  在执行前只是进入队列
                operations.multi();
                operations.opsForValue().set("key2", "value2");
                //这里获取值为null  因为只是进入队列
                Object obj = operations.opsForValue().get("key2");
                System.out.println("key2:" + obj);
                operations.opsForValue().set("key3", "value3");
                Object obj2 = operations.opsForValue().get("key3");
                System.out.println("key3:" + obj2);
                //先判断监控的key1是否被修改过，如果是则不执行事务 否则执行事务
                return operations.exec();
            }
        });
        res.put("list",list);
        return res;
    }

    /**
     * 测试流水线
     * @return
     */
    @RequestMapping("/pipeline")
    public Map<String,Object> pipeline(){
        Map<String,Object> res = new HashMap<>();
        Long start = System.currentTimeMillis();
        List list = (List) redisTemplate.executePipelined(new SessionCallback<Object>() {
            @Override
            public Object execute(RedisOperations operations) throws DataAccessException {
                for(int i=0;i<=100000;i++){
                    operations.opsForValue().set("pipeline"+i,"value"+i);
                    String str = (String) operations.opsForValue().get("pipeline"+i);
                    if(i == 10000){
                        //进入队列并未执行  所以为null
                        System.out.println("pipeline"+i+"："+str);
                    }
                }
                return null;
            }
        });
        Long end = System.currentTimeMillis();
        System.out.println("花费时间："+(end-start)+"毫秒");
        res.put("list",list);
        return res;
    }
    @RequestMapping("/sendMessageTest1")
    public Map<String,Object> sendMessage1(@RequestBody Map<String,String> req){
        Map<String,Object> res = new HashMap<>();
        String msg = req.get("message");
        //发送订阅
        redisTemplate.convertAndSend("test1",msg);
        res.put("success",true);
        return res;
    }
    @RequestMapping("/sendMessageTest2")
    public Map<String,Object> sendMessage2(@RequestBody Map<String,String> req){
        Map<String,Object> res = new HashMap<>();
        String msg = req.get("message");
        //发送订阅
        redisTemplate.convertAndSend("test2",msg);
        res.put("success",true);
        return res;
    }
}
