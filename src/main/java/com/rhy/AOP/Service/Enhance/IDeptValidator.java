package com.rhy.AOP.Service.Enhance;

import com.rhy.entity.emp.Dept;

/**
 * @Auther: Herion_Rhy
 * @Date: 2019/7/16
 * @Description: 用户验证服务
 * @Version:1.0
 */
public interface IDeptValidator {
    boolean validate(Dept dept);
}
