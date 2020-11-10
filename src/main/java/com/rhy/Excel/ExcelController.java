package com.rhy.Excel;

import com.rhy.Emp.Service.EmpServiceImpl;
import com.rhy.Excel.Utils.ExportExcelUtil;
import com.rhy.Excel.Utils.ImportExcelUtil;
import com.rhy.entity.emp.Emp;
import com.rhy.entity.emp.EmpWhere;
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

/**
 * @Auther: Herion_Rhy
 * @Date: 2019/7/21
 * @Description: excel导入与导出
 * @Version:1.0
 */
@Controller
@RequestMapping("/excel")
public class ExcelController {
    @Autowired
    private ColumnTitleMap columnTitleMap;
    @Autowired
    private EmpServiceImpl empService;
    @Autowired
    private ExportExcelUtil exportExcelUtil;
    @Autowired
    private ImportExcelUtil importExcelUtil;
    /**
     * excel导入
     */
    @RequestMapping("/import")
    @ResponseBody
    public List<Object> excelImport(@RequestPart("file") MultipartFile file) throws IOException {
        List<Object> res = importExcelUtil.imports(file);
        System.out.println(res);
        return res;
    }

    /**
     * excel导出
     */
    @RequestMapping("/export")
    public void excelExport(HttpServletResponse response, @RequestBody(required = false) EmpWhere empWhere){
        empWhere = new EmpWhere();
        //查询数据
        Map<String,Object> emps = empService.select2(empWhere);
        System.out.println(emps);
        try {
            //文件名称
            String xlsFileName = "test.xlsx";
            //获得Excel对象 ---------  以后得根据业务导出情况修改/想用统一导出工具类的话就必须得用 视图+视图模型
            Workbook workbook = exportExcelUtil.export(columnTitleMap.getColumns(), (List<T>) emps.get("datas"));
            //设置相应头和类型
            response.setContentType("application/vnd.ms-excel;charset=utf-8");
            response.setHeader("Content-disposition","attachment;filename="+xlsFileName);
            //获得http流，可以不用生成文件直接下载
            OutputStream outputStream = response.getOutputStream();
            //写入Excel流到http输出流
            workbook.write(outputStream);
            //关闭Excel流
            workbook.close();
            //关闭http流
            outputStream.close();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
