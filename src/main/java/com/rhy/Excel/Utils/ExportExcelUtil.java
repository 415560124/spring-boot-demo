package com.rhy.Excel.Utils;

import com.rhy.entity.emp.Column;
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Herion_Rhy
 * @Date: 2019/7/21
 * @Description: 导出excel工具类
 * @Version:1.0
 */
@Component
public class ExportExcelUtil {
    /**
     * 导出并下载
     * @param response http响应体用来最后 导出
     * @param columns 导出的字段集合
     * @param datas 导出数据
     */
    public Workbook export( List<Column> columns, List<T> datas) throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        Class<SXSSFWorkbook> workbookClass = SXSSFWorkbook.class;
        SXSSFWorkbook workbook = workbookClass.newInstance();
        workbookClass.getAnnotations();
        workbookClass.getFields();
        Field field = workbookClass.getField("aaa");
        field.setAccessible(true);
        field.set(workbook,111);
        workbookClass.getMethods();
        //创建excel工作对象（默认最多内置100个工作表）
        Workbook workbook = new SXSSFWorkbook();
        //工作表对象
        Sheet  sheet = null;
        //行对象
        Row row = null;
        //列对象
        Cell cell = null;

        //总行号
        int rowNo = 0;
        //页行号
        int pageRowNo = 0;
        //开始循环数据写入表中
        for(int i=0;i<datas.size();i++){
            Object nowObj = datas.get(i);
            Class cls = nowObj.getClass();
            //写入300000条数据后转入下个表
            if(rowNo % 300000 == 0){
                int currentSheet = rowNo/300000;
                System.out.println("Current Sheet:" + currentSheet);
                //建立新的工作表对象
                sheet = workbook.createSheet("工作表："+ currentSheet);
                //指定工作表对象
                sheet = workbook.getSheetAt(currentSheet);
                //重置了工作表对象 行号归零
                pageRowNo = 0;

                //定义表头
                row = sheet.createRow(pageRowNo++);
                //取出Column定义表头
                for(int j=0;j<columns.size();j++){
                    cell = row.createCell(j);
                    cell.setCellValue(columns.get(j).getTitle());
                }
                rowNo++;
            }
            //正常写入值
            row = sheet.createRow(pageRowNo++);

            for(int j=0;j<columns.size();j++){
                //获得字段对象
                Column column = columns.get(j);
                //创建excel单元格
                cell = row.createCell(j);
                //反射获取值
                Field field = cls.getDeclaredField(column.getColumn());
                field.setAccessible(true);
                //给但单元格输入值
                cell.setCellValue(field.get(nowObj).toString());

            }
        }
        return workbook;
    }
}
