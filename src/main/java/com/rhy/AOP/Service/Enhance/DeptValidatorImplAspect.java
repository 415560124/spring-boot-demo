package com.rhy.AOP.Service.Enhance;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

/**
 * @Auther: Herion_Rhy
 * @Date: 2019/7/16
 * @Description: com.rhy.AOP.Service.Enhance
 * @Version:1.0
 */
@Aspect
@Component
public class DeptValidatorImplAspect {
    //@DeclareParents(value = "com.rhy.AOP.Service.IDeptService+",defaultImpl = DeptValidatorImpl.class)
    @DeclareParents(value = "com.rhy.AOP.Service.DeptServiceImpl",defaultImpl = DeptValidatorImpl.class)
    public IDeptValidator iDeptValidator;
}
