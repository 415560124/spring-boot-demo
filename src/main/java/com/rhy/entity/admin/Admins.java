package com.rhy.entity.admin;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

/**
 * @Auther: Herion_Rhy
 * @Date: 2019/9/27
 * @Description: 管理员表
 * @Version:1.0
 */
//标识为mongdb文档
@Document
public class Admins implements Serializable {
    /**
     * 管理员id
     */
    //Mongodb文档编号，主键
    @Id
    private int aId;
    /**
     * 管理员姓名
     */
    //在Mongodb中使用a_name保存属性
    @Field("a_name")
    private String aName;
    /**
     * 管理员账号
     */
    //在Mongodb中使用a_account保存属性
    @Field("a_account")
    private String aAccount;
    /**
     * 管理员密码
     */
    //在Mongodb中使用a_password保存属性
    @Field("a_password")
    private String aPassword;
    /**
     * 上一次登陆时间
     */
    //在Mongodb中使用a_last_time保存属性
    @Field("a_last_time")
    private String aLastTime;
    /**
     * 账号状态
     */
    //在Mongodb中使用a_status保存属性
    @Field("a_status")
    private int aStatus;
    /**
     * 管理员性别id
     */
    //在Mongodb中使用a_sex保存属性
    @Field("a_sex")
    private int aSex;
    /**
     * 管理员角色
     */
    //在Mongodb中使用rule保存属性
    @DBRef
    private Rule rule;
    /**
     * 管理员性别
     */
    private SexEnum sex;

    public Rule getRule() {
        return rule;
    }

    public void setRule(Rule rule) {
        this.rule = rule;
    }

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

    public String getaAcount() {
        return aAccount;
    }

    public void setaAcount(String aAccount) {
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

    public SexEnum getSex() {
        return sex;
    }

    public void setSex(SexEnum sex) {
        this.sex = sex;
    }

    public int getaSex() {
        return aSex;
    }

    public void setaSex(int aSex) {
        this.aSex = aSex;
    }
}
