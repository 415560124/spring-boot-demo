package com.rhy.Redis.Mapper;

import com.rhy.entity.admin.Rule;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CacheMapper {
    //获取单个角色
    Rule getRule(int rId);

    //保存角色
    int insertRule(Rule rule);

    //修改角色
    int updateRule(Rule rule);

    //查询角色列表
    List<Rule> findRule(@Param("rId") int rId,@Param("rName") String rName);

    //删除角色
    int deleteRule(int rId);
}
