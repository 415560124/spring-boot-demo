package com.rhy.AOP.Service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Auther: Herion_Rhy
 * @Date: 2019/7/16
 * @Description: 多切面类
 * @Version:1.0
 */
@Aspect
@Component //必须要有此注解，让Aspect加入bean中
@Order(3)
public class DeptServiceAspect2 {
    @Pointcut(value = "execution(* com.rhy.AOP.Service.DeptServiceImpl.manyAspect(..))")  //指定类的指定方法
    //@Pointcut(value = "execution(* com.rhy.AOP.Service.DeptServiceImpl.*(..))")  //指定类的所有方法
    public void pointcut(){

    }
    @Before("pointcut()")
    public void before(JoinPoint point){ //JoinPoint是被代理的方法，运行时的元数据
        System.out.println("DeptServiceAspect2 before......");
    }
    @After("pointcut())")
    public void after(){
        System.out.println("DeptServiceAspect2 after......");
    }
    @AfterReturning("pointcut()")
    public void afterReturning(){
        System.out.println("DeptServiceAspect2 afterReturning...");
    }
    @AfterThrowing("pointcut()")
    public void afterThrowing(){
        System.out.println("DeptServiceAspect2 afterThrowing ...");
    }
}
