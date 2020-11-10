package com.rhy.AOP.DeclareParents.Service;

import org.springframework.stereotype.Component;

/**
 * @Auther: Herion_Rhy
 * @Date: 2019/7/16
 * @Description: com.rhy.AOP.DeclareParents.Service
 * @Version:1.0
 */
@Component
public class Women implements Person{
    @Override
    public void likePerson() {
        System.out.println("我是女生，我喜欢帅哥");
    }
}
