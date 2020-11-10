package com.rhy.AOP.Service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Auther: Herion_Rhy
 * @Date: 2019/7/16
 * @Description: 环绕AOP
 * @Version:1.0
 */
@Aspect
@Component
public class DeptServiceAround {
    @Pointcut("execution(* com.rhy.AOP.Service.DeptServiceImpl.pring2Dept(..))")
    public void pointcut(){

    }
    @Around("pointcut()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("around before...");
        //获得参数
        Object[] objects = joinPoint.getArgs();
        for(Object obj : objects){
            System.out.println(obj);
        }
        //执行方法
        Object res = joinPoint.proceed();
        //返回值输出
        System.out.println("返回值："+res);

        System.out.println("around after...");
    }
}
