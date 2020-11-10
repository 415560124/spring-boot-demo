package com.rhy.Emp.Mapper;

import com.rhy.entity.emp.Emp;
import com.rhy.entity.emp.EmpWhere;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Auther: Herion_Rhy
 * @Date: 2019/7/16
 * @Description: com.rhy.Emp.Mapper
 * @Version:1.0
 */
@Mapper
public interface IEmpMapper {
    //查询  -- xml动态sql
    List<Emp> select(EmpWhere empWhere);
    @Insert("insert into emp (eids,ename,esex,ebirthday,etel,eaddr,ehiredate,edids,ejids,emgr,esal,ecomm) " +
            "values(emp_id.nextval,#{ename},#{esex},#{ebirthday},#{etel},#{eaddr},#{ehiredate},#{edids},#{ejids},#{emgr},#{esal},#{ecomm})")
    int add(Emp emp);
    @Update("update emp set " +
            "ename = #{ename},esex = #{esex},ebirthday = #{ebirthday},etel = #{etel},eaddr = #{eaddr},ehiredate = #{ehiredate},edids = #{edids},emgr = #{emgr},esal = #{esal},ecomm = #{ecomm}" +
            "where eids = #{eids}")
    int update(Emp emp);
    @Delete("delete from emp where eids = #{eids}")
    int delete(Emp emp);
}
