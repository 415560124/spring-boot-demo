package com.rhy.entity.admin;

import java.util.List;

/**
 * @Auther: Herion_Rhy
 * @Date: 2019/9/27
 * @Description: 菜单表
 * @Version:1.0
 */
public class Menu {
    /**
     * 菜单id
     */
    private int mId;
    /**
     * 菜单标题
     */
    private String mTitle;
    /**
     * 菜单路径
     */
    private String mUrl;
    /**
     * 图标
     */
    private String mIcon;
    /**
     * 上级菜单id
     */
    private int mFid;
    /**
     * 子菜单
     */
    private List<Menu> menu;
    /**
     * 上级菜单
     */
    private Menu supMenu;

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmUrl() {
        return mUrl;
    }

    public void setmUrl(String mUrl) {
        this.mUrl = mUrl;
    }

    public String getmIcon() {
        return mIcon;
    }

    public void setmIcon(String mIcon) {
        this.mIcon = mIcon;
    }

    public int getmFid() {
        return mFid;
    }

    public void setmFid(int mFid) {
        this.mFid = mFid;
    }

    public List<Menu> getMenu() {
        return menu;
    }

    public void setMenu(List<Menu> menu) {
        this.menu = menu;
    }

    public Menu getSupMenu() {
        return supMenu;
    }

    public void setSupMenu(Menu supMenu) {
        this.supMenu = supMenu;
    }
}
