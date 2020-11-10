package com.rhy.Emp.Service;

import com.github.pagehelper.PageInfo;
import com.rhy.entity.emp.Emp;
import com.rhy.entity.emp.EmpWhere;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Auther: Herion_Rhy
 * @Date: 2019/7/16
 * @Description: com.rhy.Emp.Service
 * @Version:1.0
 */
@Service
public interface IEmpService {
    //Spring boot的 pageHelper返回数据
    PageInfo<Emp> select(EmpWhere empWhere);
    //自己写的 分页返回数据
    Map<String,Object> select2(EmpWhere empWhere);

    //添加 删除 修改
    int add(Emp emp);
    int update(Emp emp);
    int delete(Emp emp);
}
