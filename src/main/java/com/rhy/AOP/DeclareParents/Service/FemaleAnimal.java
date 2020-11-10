package com.rhy.AOP.DeclareParents.Service;

import org.springframework.stereotype.Component;

/**
 * @Auther: Herion_Rhy
 * @Date: 2019/7/16
 * @Description: com.rhy.AOP.DeclareParents.Service
 * @Version:1.0
 */
@Component
public class FemaleAnimal implements Animal{
    @Override
    public void eat() {
        System.out.println("我是雌性，我比雄性更喜欢吃零食");
    }
}
