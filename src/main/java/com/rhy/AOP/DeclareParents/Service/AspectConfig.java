package com.rhy.AOP.DeclareParents.Service;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

/**
 * @Auther: Herion_Rhy
 * @Date: 2019/7/16
 * @Description: com.rhy.AOP.DeclareParents.Service
 * @Version:1.0
 */
@Aspect
@Component
public class AspectConfig {
    //"+"表示person的所有子类；defaultImpl 表示默认需要添加的新的类
    //@DeclareParents(value = "com.rhy.AOP.DeclareParents.Service.Person+", defaultImpl = FemaleAnimal.class)
    @DeclareParents(value = "com.rhy.AOP.DeclareParents.Service.Women",defaultImpl = FemaleAnimal.class)
    public Animal animal;
}
