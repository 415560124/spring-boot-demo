package com.rhy.Redis.Service;

import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Auther: Herion_Rhy
 * @Date: 2019/7/17
 * @Description: com.rhy.Redis.Service
 * @Version:1.0
 */
@Service
public interface IRedisService {
    /**
     * 字符串操作
     * @return 操作结果
     */
    public Map<String,Object> stringMapper();
    /**
     * hash操作
     * @return 操作结果
     */
    public Map<String,Object> hashMapper();
    /**
     * list操作
     * @return 操作结果
     */
    public Map<String,Object> listMapper();
    /**
     * Set操作
     * @return 操作结果
     */
    public Map<String,Object> setMapper();
    /**
     * ZSet操作
     * @return 操作结果
     */
    public Map<String,Object> zSetMapper();
}
