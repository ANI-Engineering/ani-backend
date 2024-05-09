package com.ani.backend.controllers;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.ani.backend.service.PdfService;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class PdfController {
    @Autowired
    private PdfService pdfService;

   
    public PdfController(PdfService pdfService) {
        this.pdfService = pdfService;
    }
   
    @GetMapping("pdf/generate")
    public void generatePdf(HttpServletResponse response) throws IOException {
        response.setContentType("application/pdf");
         DateFormat dateFormat =  new SimpleDateFormat("yyyy-mm-dd:hh:mm:ss");
         String currentDateTime = dateFormat.format(new Date());
         String headerKey = "Content-Disposition";
         String headerValue = "attachment; filename=pdf_" + currentDateTime + ".pdf";
         response.setHeader(headerKey, headerValue);
         this.pdfService.export(response);
    }
}
