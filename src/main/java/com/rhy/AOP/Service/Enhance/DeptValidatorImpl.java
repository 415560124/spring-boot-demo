package com.rhy.AOP.Service.Enhance;

import com.rhy.entity.emp.Dept;
import org.springframework.stereotype.Service;

/**
 * @Auther: Herion_Rhy
 * @Date: 2019/7/16
 * @Description: IDeptValidator 用户验证实现 -- 增强后实现类
 * @Version:1.0
 */
@Service
public class DeptValidatorImpl implements IDeptValidator {
    @Override
    public boolean validate(Dept dept) {
        System.out.println("引入新的接口："+DeptValidatorImpl.class.getSimpleName());
        return dept != null;
    }
}
