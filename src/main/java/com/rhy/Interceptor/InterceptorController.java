package com.rhy.Interceptor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: Herion_Rhy
 * @Date: 2019/7/21
 * @Description: com.rhy.Interceptor
 * @Version:1.0
 */
@RestController
@RequestMapping("/interceptor")
public class InterceptorController {
    @RequestMapping("/start")
    public String start(){
        System.out.println("执行处理器逻辑");
        return "ok";
    }
}
