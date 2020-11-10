package com.rhy.entity.emp;

import org.springframework.stereotype.Component;

/**
 * @Auther: Herion_Rhy
 * @Date: 2019/7/21
 * @Description: 导出字段实体类
 * @Version:1.0
 */
public class Column {
    private String column;
    private String title;

    public Column() {
    }

    public Column(String column, String title) {
        this.column = column;
        this.title = title;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
