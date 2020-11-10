package com.rhy.PdfExcel.Utils;


import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @Auther: Herion_Rhy
 * @Date: 2019/7/19
 * @Description: PDF导出视图类
 * @Version:1.0
 */
public class PdfView extends AbstractPdfView {
    private PdfExport pdfExport= null;
    public PdfView(PdfExport pdfExport){
        this.pdfExport = pdfExport;
    }
    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter write, HttpServletRequest request, HttpServletResponse response) throws Exception {
        pdfExport.make(model,document,write,request,response);
    }

}
