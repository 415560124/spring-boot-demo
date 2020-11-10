package com.rhy.AOP.Service;

import com.rhy.entity.emp.Dept;
import org.springframework.stereotype.Service;

/**
 * @Auther: Herion_Rhy
 * @Date: 2019/7/16
 * @Description: com.rhy.AOP.Service
 * @Version:1.0
 */

public interface IDeptService {
    public void pringDept(Dept dept);
    public Dept pring2Dept(Dept dept);
    public Dept manyAspect(Dept dept);
}
