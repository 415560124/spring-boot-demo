package com.rhy.entity.admin;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.List;

/**
 * @Auther: Herion_Rhy
 * @Date: 2019/9/27
 * @Description: 角色表
 * @Version:1.0
 */
@Document
public class Rule implements Serializable {
    /**
     * 角色id
     */
    @Id
    private int rId;
    /**
     * 角色名称
     */
    @Field("r_name")
    private String rName;
    /**
     * 角色菜单
     */
    private List<RuleMenus> ruleMenus;

    public int getrId() {
        return rId;
    }

    public void setrId(int rId) {
        this.rId = rId;
    }

    public String getrName() {
        return rName;
    }

    public void setrName(String rName) {
        this.rName = rName;
    }

    public List<RuleMenus> getRuleMenus() {
        return ruleMenus;
    }

    public void setRuleMenus(List<RuleMenus> ruleMenus) {
        this.ruleMenus = ruleMenus;
    }
}
