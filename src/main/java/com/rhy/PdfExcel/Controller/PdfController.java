package com.rhy.PdfExcel.Controller;

import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.rhy.Emp.Service.EmpServiceImpl;
import com.rhy.PdfExcel.Utils.PdfExport;
import com.rhy.PdfExcel.Utils.PdfView;
import com.rhy.entity.emp.Emp;
import com.rhy.entity.emp.EmpWhere;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import java.awt.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @Auther: Herion_Rhy
 * @Date: 2019/7/19
 * @Description: com.rhy.PdfExcel.Controller
 * @Version:1.0
 */
@Controller
@RequestMapping("/pdf")
public class PdfController {
    @Autowired
    private EmpServiceImpl empService;

    @RequestMapping("/export")
    public ModelAndView export(@RequestBody(required = false) EmpWhere empWhere){
        if(empWhere == null){
            empWhere = new EmpWhere();
        }
        Map<String,Object> res = empService.select2(empWhere);
        List<Emp> emps = (List<Emp>) res.get("datas");
        View view = new PdfView(getExport());
        ModelAndView mv = new ModelAndView();
        //设置视图
        mv.setView(view);
        //设置数据模型
        mv.addObject("emps",emps);
        return mv;
    }

    /**
     * 导出Pdf自定义
     * @return
     */
    public PdfExport getExport(){
        //使用Lambda表达式自定义导出
        return (model,document,writer,request,response)->{

            try {
            //A4纸张
            document.setPageSize(PageSize.A4);

            //标题
            document.addTitle("用户信息");

            //换行
            document.add(new Chunk("\n"));

            //表格，3列
            PdfPTable table = new PdfPTable(3);
            //中文编码
            BaseFont baseFontChinese = BaseFont.createFont("STSong-Light","UniGB-UCS2-H",BaseFont.NOT_EMBEDDED);
            //单元格字体，定义为蓝色加粗
            Font font = new Font(baseFontChinese,12,Font.NORMAL);
            font.setColor(Color.BLUE);
            font.setStyle(Font.BOLD);

            //单元格
            PdfPCell cell = null;
            //标题
            cell = new PdfPCell(new Paragraph("编号",font));
            //居中对齐
            cell.setHorizontalAlignment(1);
            table.addCell(cell);
            //标题
            cell = new PdfPCell(new Paragraph("名称",font));
            //居中对齐
            cell.setHorizontalAlignment(1);
            table.addCell(cell);
            //标题
            cell = new PdfPCell(new Paragraph("性别",font));
            //居中对齐
            cell.setHorizontalAlignment(1);
            table.addCell(cell);

            //获取数据模型中的用户列表
            List<Emp> emps = (List<Emp>) model.get("emps");
            for(Emp emp : emps){
                System.out.println(emp);
                document.add(new Chunk("\n"));
                cell = new PdfPCell(new Paragraph(emp.getEids() + ""));
                table.addCell(cell);
                System.out.println(emp.getEname());
                cell = new PdfPCell(new Paragraph(emp.getEname()));
                table.addCell(cell);
                cell = new PdfPCell(new Paragraph(emp.getEsex() == 1 ? "男" : "女"));
                table.addCell(cell);
            }
            //在文档中加入表格
            document.add(table);

            } catch (DocumentException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
    }
}
