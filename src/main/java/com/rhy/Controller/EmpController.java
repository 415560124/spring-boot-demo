package com.rhy.Controller;

import com.github.pagehelper.PageInfo;
import com.rhy.Emp.Service.IEmpService;
import com.rhy.entity.emp.Emp;
import com.rhy.entity.emp.EmpWhere;
import com.rhy.utils.PageWhere;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: Herion_Rhy
 * @Date: 2019/7/16
 * @Description: com.rhy.Controller
 * @Version:1.0
 */
@RestController
@RequestMapping("/emp")
public class EmpController {
    @Autowired
    @Qualifier("empServiceImpl")
    //@Qualifier("empServiceImpl2")  //消除歧义性，可以指定子实现类的名称
    private IEmpService iEmpService;
    //带参构造指定依赖类
    public EmpController(@Autowired @Qualifier("empServiceImpl") IEmpService service) {
        iEmpService = service;
    }

    @RequestMapping("/select")
    public Map<String,Object> select(@RequestBody EmpWhere empWhere){
        Map<String,Object> res = new HashMap<>();
        PageInfo<Emp> emps = iEmpService.select(empWhere);
        res.put("code",1);
        res.put("msg","查询成功");
        res.put("datas",emps);
        return res;
    }
    @RequestMapping("/select2")
    public Map<String,Object> select2(@RequestBody EmpWhere empWhere){
        Map<String,Object> res = new HashMap<>();
        Map<String,Object> emps = iEmpService.select2(empWhere);
        res.put("code",1);
        res.put("msg","查询成功");
        res.put("datas",emps);
        return res;
    }

    @RequestMapping("/add")
    public Map<String,Object> add(@RequestBody Emp emp){
        Map<String,Object> res = new HashMap<>();
        int add = iEmpService.add(emp);
        if(add != 0){
            res.put("code",1);
            res.put("msg","添加成功");
        }else{
            res.put("code",2);
            res.put("msg","添加失败");
        }
        return res;
    }
    @RequestMapping("/update")
    public Map<String,Object> update(@RequestBody Emp emp){
        Map<String,Object> res = new HashMap<>();
        int add = iEmpService.update(emp);
        if(add != 0){
            res.put("code",1);
            res.put("msg","修改成功");
        }else{
            res.put("code",2);
            res.put("msg","修改失败");
        }
        return res;
    }
    @RequestMapping("/delete")
    public Map<String,Object> delete(@RequestBody Emp emp){
        Map<String,Object> res = new HashMap<>();
        int add = iEmpService.delete(emp);
        if(add != 0){
            res.put("code",1);
            res.put("msg","删除成功");
        }else{
            res.put("code",2);
            res.put("msg","删除失败");
        }
        return res;
    }
}
