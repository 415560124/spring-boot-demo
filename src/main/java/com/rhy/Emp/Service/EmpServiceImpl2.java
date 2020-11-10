package com.rhy.Emp.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rhy.Emp.Mapper.IEmpMapper;
import com.rhy.entity.emp.Emp;
import com.rhy.entity.emp.EmpWhere;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: Herion_Rhy
 * @Date: 2019/7/16
 * @Description: com.rhy.Emp.Service
 * @Version:1.0
 */
@Service
public class EmpServiceImpl2 implements IEmpService{
    @Autowired
    private IEmpMapper iEmpMapper;
    @Override
    public PageInfo<Emp> select(EmpWhere empWhere) {
        Page page = PageHelper.startPage(empWhere.getPageNow(),empWhere.getPageSize());
        List<Emp> empList = iEmpMapper.select(empWhere);
        empWhere.setPageTotal(page.getTotal());
        System.out.println("EmpServiceImpl2");
        PageInfo<Emp> res = new PageInfo<>(empList);
        return res;
    }

    @Override
    public Map<String,Object> select2(EmpWhere empWhere) {
        Page page = PageHelper.startPage(empWhere.getPageNow(),empWhere.getPageSize());
        List<Emp> empList = iEmpMapper.select(empWhere);
        empWhere.setPageTotal(page.getTotal());
        Map<String,Object> res = new HashMap<>();
        res.put("datas",empList);
        res.put("where",empWhere);
        return res;
    }

    @Override
    public int add(Emp emp) {
        return 0;
    }

    @Override
    public int update(Emp emp) {
        return 0;
    }

    @Override
    public int delete(Emp emp) {
        return 0;
    }

}
