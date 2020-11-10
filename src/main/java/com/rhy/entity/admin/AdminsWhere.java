package com.rhy.entity.admin;

import java.util.List;

/**
 * @Auther: Herion_Rhy
 * @Date: 2019/10/1
 * @Description: com.rhy.entity.admin
 * @Version:1.0
 */
public class AdminsWhere {
    /**
     * 管理员id
     */
    private int aId;
    /**
     * 管理员姓名
     */
    private String aName;
    /**
     * 管理员账号
     */
    private String aAccount;
    /**
     * 管理员密码
     */
    private String aPassword;
    /**
     * 上一次登陆时间
     */
    private String aLastTime;
    /**
     * 账号状态
     */
    private int aStatus;
    /**
     * 管理员性别id
     */
    private int aSex;
    /**
     * 管理员编号列表
     */
    private List<Integer> idList;
    /**
     * 管理员账号列表
     */
    private List<String> AccountList;

    public int getaId() {
        return aId;
    }

    public void setaId(int aId) {
        this.aId = aId;
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    public String getaAccount() {
        return aAccount;
    }

    public void setaAccount(String aAccount) {
        this.aAccount = aAccount;
    }

    public String getaPassword() {
        return aPassword;
    }

    public void setaPassword(String aPassword) {
        this.aPassword = aPassword;
    }

    public String getaLastTime() {
        return aLastTime;
    }

    public void setaLastTime(String aLastTime) {
        this.aLastTime = aLastTime;
    }

    public int getaStatus() {
        return aStatus;
    }

    public void setaStatus(int aStatus) {
        this.aStatus = aStatus;
    }

    public int getaSex() {
        return aSex;
    }

    public void setaSex(int aSex) {
        this.aSex = aSex;
    }

    public List<Integer> getIdList() {
        return idList;
    }

    public void setIdList(List<Integer> idList) {
        this.idList = idList;
    }

    public List<String> getAccountList() {
        return AccountList;
    }

    public void setAccountList(List<String> accountList) {
        AccountList = accountList;
    }

    @Override
    public String toString() {
        return "AdminsWhere{" +
                "aId=" + aId +
                ", aName='" + aName + '\'' +
                ", aAccount='" + aAccount + '\'' +
                ", aPassword='" + aPassword + '\'' +
                ", aLastTime='" + aLastTime + '\'' +
                ", aStatus=" + aStatus +
                ", aSex=" + aSex +
                ", idList=" + idList +
                ", AccountList=" + AccountList +
                '}';
    }
}
