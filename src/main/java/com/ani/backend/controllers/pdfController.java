package com.ani.backend.controllers;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.ani.backend.service.pdfService;


import jakarta.servlet.http.HttpServletResponse;
@Controller
public class pdfController {

    private final pdfService Pdfservice;

    public pdfController(pdfService Pdfservice) {

        this.Pdfservice = Pdfservice;
    }

    @GetMapping("/pdf/generate")
    public void generatePdf(HttpServletResponse response) throws IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd:hh:mm:ss");
        
        String currentDateTime = dateFormat.format(new Date());
        String headerkey = "Content-Disposition";
        String headervalue = "attachment; filename=pdf_" + currentDateTime + ".pdf";
        response.setHeader(headerkey, headervalue);

        this.Pdfservice.export(response);
    }
}
