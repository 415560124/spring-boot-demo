package com.rhy.Controller;

import com.rhy.Properties.DataBaseProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: Herion_Rhy
 * @Date: 2019/7/15
 * @Description: com.rhy.Controller
 * @Version:1.0
 */
@RestController
public class TestController {
    @Autowired
    DataBaseProperties properties;
    @RequestMapping("/")
    public Map<String,Object> hello(){
        Map<String,Object> res = new HashMap<>();
        res.put("code","1");
        res.put("data","Hello World!");
        return res;

    }
    @RequestMapping("/properties")
    public Map<String,Object> properties(){
        Map<String,Object> res = new HashMap<>();
        res.put("drivername",properties.getDriverName());
        res.put("url",properties.getUrl());
        res.put("username",properties.getUsername());
        res.put("password",properties.getPassword());
        return res;
    }

}
