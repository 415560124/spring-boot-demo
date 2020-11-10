package com.rhy.Redis.Service;

import com.rhy.Redis.Mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Auther: Herion_Rhy
 * @Date: 2019/7/17
 * @Description: com.rhy.Redis.Service
 * @Version:1.0
 */
@Service
public class RedisServiceImpl implements IRedisService{
    @Autowired
    private StringMapper stringMapper;
    @Autowired
    private HashMapper hashMapper;
    @Autowired
    private ListMapper listMapper;
    @Autowired
    private SetMapper setMapper;
    @Autowired
    private ZSetMapper zsetMapper;
    @Override
    public Map<String, Object> stringMapper() {
        return stringMapper.testString();
    }

    @Override
    public Map<String, Object> hashMapper() {
        return hashMapper.testHash();
    }

    @Override
    public Map<String, Object> listMapper() {
        return listMapper.testList();
    }

    @Override
    public Map<String, Object> setMapper() {
        return setMapper.testSet();
    }
    @Override
    public Map<String, Object> zSetMapper() {
        return zsetMapper.testZSet();
    }


}
