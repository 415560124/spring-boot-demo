package com.rhy.AOP.Service;

import com.rhy.entity.emp.Dept;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @Auther: Herion_Rhy
 * @Date: 2019/7/16
 * @Description: 切面类 对应的类中方法
 * @Version:1.0
 */
@Aspect
@Component //必须要有此注解，让Aspect加入bean中
public class DeptServiceAspect {
    @Pointcut(value = "execution(* com.rhy.AOP.Service.DeptServiceImpl.pringDept(..))")  //指定类的指定方法
    //@Pointcut(value = "execution(* com.rhy.AOP.Service.DeptServiceImpl.*(..))")  //指定类的所有方法
    public void pointcut(){

    }
    @Before("pointcut() && args(dept)")
    public void before(JoinPoint point, Dept dept){ //JoinPoint是被代理的方法，运行时的元数据
        //可以从point或者dept参数中取出元数据
        Object[] objects = point.getArgs();
        for(Object object : objects){
            System.out.println(object);
        }
        System.out.println(dept);
        System.out.println("before......");
    }
    @After("pointcut()")
    public void after(){
        System.out.println("after......");
    }
    @AfterReturning("pointcut()")
    public void afterReturning(){
        System.out.println("afterReturning...");
    }
    @AfterThrowing("pointcut()")
    public void afterThrowing(){
        System.out.println("afterThrowing ...");
    }
}
