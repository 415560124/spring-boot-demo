package com.rhy.Redis.Controller;

import com.rhy.Redis.Service.CacheServiceImpl;
import com.rhy.entity.admin.Rule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cache")
public class CacheController {

    @Autowired
    CacheServiceImpl cacheService;

    Map<String,Object> res = new HashMap<>();


    //获取单个角色
    @RequestMapping("/getRule")
    public Rule getRule(@RequestBody Map<String,Object> req){
        return cacheService.getRule((Integer) req.get("rId"));
    }

    //保存角色
    @RequestMapping("/insertRule")
    public Rule insertRule(@RequestBody Rule rule){
        cacheService.insertRule(rule);
        return rule;
    }

    //修改角色
    @RequestMapping("/updateRule")
    public int updateRule(@RequestBody Rule rule){
        if(cacheService.updateRule(rule) != null){
            return 1;
        }
        return 0;
    }

    //查询角色列表
    @RequestMapping("/findRule")
    public List<Rule> findRule(@RequestBody Map<String,Object> req){
        return cacheService.findRule((int)req.get("rId"),(String) req.get("rName"));
    }

    //删除角色
    @RequestMapping("/deleteRule")
    public int deleteRule(@RequestBody Map<String,Object> req){
        return cacheService.deleteRule((Integer) req.get("rId"));
    }
}
