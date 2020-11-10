package com.rhy.Admins.Dao;

import com.rhy.entity.admin.Admins;
import com.rhy.entity.admin.Menu;
import com.rhy.entity.admin.Rule;
import com.rhy.entity.admin.RuleMenus;
import org.apache.ibatis.annotations.Mapper;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * @Auther: Herion_Rhy
 * @Date: 2019/9/28
 * @Description: com.rhy.Admins.Dao
 * @Version:1.0
 */
@Mapper
public interface IAdminsDao {
    /**
     * 查询所有管理员列表
     * @return 管理员信息
     */
    List<Admins> select();

    /**
     * 按id查询管理员信息
     * @param id 管理员id
     * @return 管理员信息
     */
    Admins getAdminById(int id);

    /**
     * 按id查询角色信息
     * @param id 角色id
     * @return 角色信息
     */
    Rule getRuleById(int id);
    /**
     * 按角色id查询菜单id列表(根菜单)
     * @param id 角色id
     * @return 菜单id集合（根菜单）
     */
    List<RuleMenus> getMenuByRId(int id);
    /**
     * 按菜单id查询下级菜单id列表
     * @param id 菜单id
     * @return 菜单id集合
     */
    List<RuleMenus> getRuleMenuByMId(int id);
    /**
     * 按id查询菜单信息
     * @param id 菜单id
     * @return 菜单信息
     */
    Menu getMenuById(int id);
    /**
     * 按id查询菜单信息（没有上级菜单）
     * @param id 菜单id
     * @return 菜单信息
     */
    Menu getMenuByIdNotFid(int id);
    /**
     * 按id查询菜单信息（没有下级菜单）
     * @param id 菜单id
     * @return 菜单信息
     */
    Menu getMenuByIdNotBottom(int id);

    /**
     * 按菜单id查询下级菜单
     * @param id 菜单id
     * @return 下级菜单集合
     */
    List<Menu> getMenuByMId(int id);
}
