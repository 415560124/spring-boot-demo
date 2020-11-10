package com.rhy.PdfExcel.Utils;

import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @Auther: Herion_Rhy
 * @Date: 2019/7/19
 * @Description: PDF导出接口
 * @Version:1.0
 */
public interface PdfExport {
    public void make(Map<String,Object> model, Document document , PdfWriter writer, HttpServletRequest request, HttpServletResponse response);
}
