package com.rhy.LazyInit;

import com.rhy.LazyInit.Lazy.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: Herion_Rhy
 * @Date: 2019/7/16
 * @Description: com.rhy.LazyInit
 * @Version:1.0
 */
@RestController
@RequestMapping("/lazyInit")
public class LazyInitController {
    @Autowired
    private Person personImpl;
    @RequestMapping("/test")
    public String test(){
        personImpl.service();
        return "正在测试";
    }
}
