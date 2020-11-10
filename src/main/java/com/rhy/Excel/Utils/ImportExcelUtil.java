package com.rhy.Excel.Utils;

import com.rhy.entity.emp.Emp;
import org.apache.poi.ss.usermodel.*;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Herion_Rhy
 * @Date: 2019/7/21
 * @Description: 导入工具类
 * @Version:1.0
 */
@Component
public class ImportExcelUtil {
    public List<Object> imports(MultipartFile file) throws IOException {
        List<Object> res = new ArrayList<>();
        // 先读取文件流 输入到 POIFSFileSystem 对象中解析，将POIFSFileSystem对象输入到HSSFWorkbook中生成对象信息
        Workbook workbook = WorkbookFactory.create(file.getInputStream());
        //获得sheet长度
        int sheetLeng = workbook.getNumberOfSheets();
        //遍历表
        for(int i=0;i<sheetLeng;i++){
            //获得第i个表对象
            Sheet sheet = workbook.getSheetAt(i);
            //获得表对象中的行数
            int rowLeng = sheet.getPhysicalNumberOfRows();
            //遍历行
            for(int j =0;j<rowLeng;j++){
                //标题行
                if(j == 0){
                    continue;
                }else{
                    //获取当前行
                    Row row = sheet.getRow(j);
                    //获取一行有多少个单元格
                    int cellLeng = row.getPhysicalNumberOfCells();
                    //转成对象模型
                    Emp emp = new Emp();
                    //遍历单元格
                    for(int k=0;k<cellLeng;k++){
                        Cell cell = row.getCell(k);
                        //
                        if(k == 0){
                            emp.setEids( Integer.parseInt(cell.getStringCellValue()));
                        }else if(k == 1){
                            emp.setEname(cell.getStringCellValue());
                        }else if(k == 2){
                            emp.setEsex(Integer.parseInt(cell.getStringCellValue()));
                        }else if(k == 3){
                            emp.setEbirthday(Long.parseLong(cell.getStringCellValue()) );
                        }else if(k == 4){
                            emp.setEtel(cell.getStringCellValue());
                        }else if(k == 5){
                            emp.setEaddr(cell.getStringCellValue());
                        }
                    }
                    //写入到集合中
                    res.add(emp);
                }
            }
        }
        return res;
    }
}
