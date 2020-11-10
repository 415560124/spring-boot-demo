package com.rhy.Admins.Dao;

import com.rhy.entity.admin.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Auther: Herion_Rhy
 * @Date: 2019/9/28
 * @Description: 动态sql测试
 * @Version:1.0
 */
@Mapper
public interface IAdminsDynSqlDao {
    /**
     * 管理员搜索
     * @param adminsWhere 搜索条件POJO
     * @return  管理员信息列表
     */
    List<Admins> getAdmins(AdminsWhere adminsWhere);


    /**
     * 按菜单id查询
     * @param id 编号
     * @return 菜单信息
     */
    Menu getMenuById(int id);

    /**
     * 按角色id查询
     * @param id 角色id
     * @return 角色信息
     */
    Rule getRuleById(int id);

    /**
     * 按角色id查询角色菜单
     * @param id 角色id
     * @return 角色信息
     */
    RuleMenus getRuleMenuByRId(int rId);

    /**
     * 按上级菜单查询角色菜单
     * @param id 菜单id
     * @return 角色菜单列表
     */
    List<RuleMenus> getRuleMenuByMFid(RuleMenus ruleMenus);
}
