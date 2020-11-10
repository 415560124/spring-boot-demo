package com.rhy.entity.admin;

import java.util.List;

/**
 * @Auther: Herion_Rhy
 * @Date: 2019/9/30
 * @Description: com.rhy.entity.admin
 * @Version:1.0
 */
public class RuleMenus {
    /**
     * 角色id
     */
    private int rmRId;
    /**
     * 菜单信息
     */
    private Menu menu;
    /**
     * 下级菜单集合
     */
    private List<RuleMenus> roleMenus;

    private int rmFId;

    public int getRmFId() {
        return rmFId;
    }

    public void setRmFId(int rmFId) {
        this.rmFId = rmFId;
    }

    public int getRmRId() {
        return rmRId;
    }

    public void setRmRId(int rmRId) {
        this.rmRId = rmRId;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public List<RuleMenus> getRoleMenus() {
        return roleMenus;
    }

    public void setRoleMenus(List<RuleMenus> roleMenus) {
        this.roleMenus = roleMenus;
    }
}
