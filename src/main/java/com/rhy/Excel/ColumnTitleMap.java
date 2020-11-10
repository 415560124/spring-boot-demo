package com.rhy.Excel;

import com.rhy.entity.emp.Column;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Herion_Rhy
 * @Date: 2019/7/21
 * @Description: 数据导出，生成excel文件时的列名集合
 * @Version:1.0
 */
@Component
public class ColumnTitleMap {
    // 字段名集合
    private List<Column> columns;

    public ColumnTitleMap() {
        columns = new ArrayList<>();
        //这里应该查数据库
        columns.add(new Column("eids","ID"));
        columns.add(new Column("ename","姓名"));
        columns.add(new Column("esex","性别"));
        columns.add(new Column("ebirthday","生日"));
        columns.add(new Column("etel","电话"));
        columns.add(new Column("eaddr","住址"));
    }

    public ColumnTitleMap(ArrayList<Column> columns) {
        this.columns = columns;
    }

    public List<Column> getColumns() {
        return columns;
    }

    public void setColumns(ArrayList<Column> columns) {
        this.columns = columns;
    }
}
