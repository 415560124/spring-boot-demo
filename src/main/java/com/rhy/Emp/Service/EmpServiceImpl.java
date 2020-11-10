package com.rhy.Emp.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rhy.Emp.Mapper.IEmpMapper;
import com.rhy.entity.emp.Emp;
import com.rhy.entity.emp.EmpWhere;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
public class EmpServiceImpl implements IEmpService{
    @Autowired
    private IEmpMapper iEmpMapper;
    @Override
    public PageInfo<Emp> select(EmpWhere empWhere) {
        Page page = PageHelper.startPage(empWhere.getPageNow(),empWhere.getPageSize());
        List<Emp> empList = iEmpMapper.select(empWhere);
        empWhere.setPageTotal(page.getTotal());

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
    /**
     * 需要事务，它是默认传播行为，
     * 如果当前存在事务，就沿用当前事务，否则创建一个事务运行子方法
     */
    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED,timeout = 2)
    public int add(Emp emp) {
        return iEmpMapper.add(emp);
    }

    /**
     * 无论当前事务是否存在，都会创建新事务运行方法
     * 这样新事物就可以拥有新的锁和隔离级别等特性，与当前事务相互独立
     */
    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRES_NEW,timeout = 2)
    public int update(Emp emp) {
        return iEmpMapper.update(emp);
    }
    /**
     * 在当前方法调用子方法时，如果子方法发生异常
     * 只滚回子方法执行过的SQL，而不回滚当前方法的事务
     */
    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.NESTED,timeout = 2)
    public int delete(Emp emp) {
        return iEmpMapper.delete(emp);
    }
}
