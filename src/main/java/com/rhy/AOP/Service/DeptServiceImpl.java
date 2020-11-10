package com.rhy.AOP.Service;

import com.rhy.entity.emp.Dept;
import org.springframework.stereotype.Service;

/**
 * @Auther: Herion_Rhy
 * @Date: 2019/7/16
 * @Description: com.rhy.AOP.Service
 * @Version:1.0
 */
@Service("deptServletImpl")
public class DeptServiceImpl implements IDeptService{
    @Override
    public void pringDept(Dept dept) {
        if(dept == null){
            throw new RuntimeException("检查部门参数是否为空");
        }
        System.out.println("dids="+dept.getDids());
        System.out.println("dname="+dept.getDname());
    }

    @Override
    public Dept pring2Dept(Dept dept) {
        if(dept == null){
            throw new RuntimeException("检查部门参数是否为空");
        }
        System.out.println("dids2="+dept.getDids());
        System.out.println("dname2="+dept.getDname());
        return dept;
    }

    @Override
    public Dept manyAspect(Dept dept) {
        if(dept == null){
            throw new RuntimeException("检查部门参数是否为空");
        }
        System.out.println("dids2="+dept.getDids());
        System.out.println("dname2="+dept.getDname());
        return dept;
    }
}
