package com.ani.backend.service;

import java.io.IOException;
import org.springframework.stereotype.Service;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.CMYKColor;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class PdfService {

// //  add A4.page

public void export(HttpServletResponse response) throws IOException{
    float width = PageSize.A4.getWidth() + 60; // Increase the width by 10 units
    float height = PageSize.A4.getHeight() + 30; // Increase the height by 10 units
    Rectangle customSize = new Rectangle(width, height);
    Document document = new Document(customSize);
    PdfWriter.getInstance(document, response.getOutputStream());
    document.setPageSize(customSize);
    document.open();
       

     // add img logo  
    Image logo = Image.getInstance("/Users/apple/Documents/ani-backend-1/src/main/java/com/ani/backend/img/logo.png");
    logo.scaleAbsolute(100, 100);
    logo.setAlignment(Image.ALIGN_LEFT);
    logo.setAbsolutePosition(70f, document.getPageSize().getHeight() - 80f - 50f);
    logo.setBorder(Rectangle.NO_BORDER);
    document.add(logo);

       //  add title

     Font fontTittle = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        fontTittle.setSize(15);
          Paragraph paragraph = new Paragraph("ANI LIVING SPACES PRIVATE LIMITED", fontTittle);
           paragraph.setAlignment(Paragraph.ALIGN_RIGHT);
           document.add(paragraph);

           // add address  

           Font font = FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD);
           font.setSize(10);
           PdfPTable table4 = new PdfPTable(2);
           table4.setWidthPercentage(45);
           float[] ColumnWidths = {0.10f, 0.4f};
           table4.setWidths(ColumnWidths);          
           table4.setHorizontalAlignment(Element.ALIGN_RIGHT);
           
           PdfPCell cell1 = new PdfPCell(new Phrase("Address:", font));
           cell1.setBorder(Rectangle.NO_BORDER);
           table4.addCell(cell1);
           
           PdfPCell cell2 = new PdfPCell(new Phrase("224/2 Surabhi, 1st Cross Nobel Residency\nTejaswini Nagar Phase 2, Bengaluru 560076.", font));
           cell2.setBorder(Rectangle.NO_BORDER);
           table4.addCell(cell2);
           
           cell1 = new PdfPCell(new Phrase("Phone NO:", font));
           cell1.setBorder(Rectangle.NO_BORDER);
           table4.addCell(cell1);
           
           cell2 = new PdfPCell(new Phrase("7022765665", font));
           cell2.setBorder(Rectangle.NO_BORDER);
           table4.addCell(cell2);
           
           cell1 = new PdfPCell(new Phrase("Email:", font));
           cell1.setBorder(Rectangle.NO_BORDER);
           table4.addCell(cell1);
           
           cell2 = new PdfPCell(new Phrase("anilivingspaces@gmail.com", font));
           cell2.setBorder(Rectangle.NO_BORDER);
           table4.addCell(cell2);
           
           cell1 = new PdfPCell(new Phrase("Web:", font));
           cell1.setBorder(Rectangle.NO_BORDER);
           table4.addCell(cell1);
           
           cell2 = new PdfPCell(new Phrase("www.anilivingspaces.com", font));
           cell2.setBorder(Rectangle.NO_BORDER);
           table4.addCell(cell2);
           
           cell1 = new PdfPCell(new Phrase("GST No:", font));
           cell1.setBorder(Rectangle.NO_BORDER);
           table4.addCell(cell1);
           
           cell2 = new PdfPCell(new Phrase("29AAUCA4018K1Z7", font));
           cell2.setBorder(Rectangle.NO_BORDER);
           table4.addCell(cell2);
           
           cell1 = new PdfPCell(new Phrase("Invoice No:", font));
           cell1.setBorder(Rectangle.NO_BORDER);
           table4.addCell(cell1);
           
           cell2 = new PdfPCell(new Phrase("ANI/23-24/0009", font));
           cell2.setBorder(Rectangle.NO_BORDER);
           table4.addCell(cell2);
           document.add(table4);
          
         Table table6 = new Table(1) ; 
         table6.setWidth(100);
         table6.setBorderWidth(1); // Set border width to 2
         table6.setBorderColor(CMYKColor.BLACK); // Set border color to black
         document.add(table6);

         //  adding User Details 
         Font font1Tittle1 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
          font1Tittle1.setSize(15);
          Paragraph paragraphh = new Paragraph("USER DETAILS", font1Tittle1);
          paragraphh.setAlignment(Paragraph.ALIGN_LEFT);
          document.add(paragraphh);
          
          //  adding the  Table with 2 colomns 
           PdfPTable table5 = new PdfPTable(2);
           table5.setHorizontalAlignment(Element.ALIGN_RIGHT);
           PdfPTable outerTable = new PdfPTable(2);
           outerTable.setWidthPercentage(100); 
           outerTable.getDefaultCell().setBorder(Rectangle.NO_BORDER);
        
           // adding user Booking Date
           PdfPCell cell3 = new PdfPCell(new Phrase("Invoice Date:"));
           cell3.setBorder(Rectangle.NO_BORDER);
           table5.addCell(cell3);
           
           PdfPCell cell4 = new PdfPCell(new Phrase("April 20, 2024", font));
           cell4.setBorder(Rectangle.NO_BORDER);
           table5.addCell(cell4);
           
           cell3 = new PdfPCell(new Phrase("Booking ID:"));
           cell3.setBorder(Rectangle.NO_BORDER);
           table5.addCell(cell3);
           
           cell4 = new PdfPCell(new Phrase("45774", font));
           cell4.setBorder(Rectangle.NO_BORDER);
           table5.addCell(cell4);

           cell3 = new PdfPCell(new Phrase("Booking Date:"));
           cell3.setBorder(Rectangle.NO_BORDER);
           table5.addCell(cell3);

           cell4 = new PdfPCell(new Phrase("April 19, 2024", font));
           cell4.setBorder(Rectangle.NO_BORDER);
           table5.addCell(cell4);

           cell3 = new PdfPCell(new Phrase("Check In:"));
           cell3.setBorder(Rectangle.NO_BORDER);
           table5.addCell(cell3);

           cell4 = new PdfPCell(new Phrase("April 20, 2024", font));
           cell4.setBorder(Rectangle.NO_BORDER);
           table5.addCell(cell4);
            
           cell3 = new PdfPCell(new Phrase("Check Out:"));
           cell3.setBorder(Rectangle.NO_BORDER);
           table5.addCell(cell3);

           cell4 = new PdfPCell(new Phrase("April 22, 2024", font));
           cell4.setBorder(Rectangle.NO_BORDER);
           table5.addCell(cell4);
         
           // adding user details
           PdfPTable table7 = new PdfPTable(2);
           table7.setHorizontalAlignment(Element.ALIGN_LEFT);
           
           PdfPCell cell5 = new PdfPCell(new Phrase("Name:"));
           cell5.setBorder(Rectangle.NO_BORDER);
           table7.addCell(cell5);
           
           
           PdfPCell cell7 = new PdfPCell(new Phrase("Mithilesh", font));
           cell7.setBorder(Rectangle.NO_BORDER);
           table7.addCell(cell7);

           cell5 = new PdfPCell(new Phrase("Phone No:"));
           cell5.setBorder(Rectangle.NO_BORDER);
           table7.addCell(cell5);
           
           
           cell7 = new PdfPCell(new Phrase("8887689276", font));
           cell7.setBorder(Rectangle.NO_BORDER);
           table7.addCell(cell7);

           cell5 = new PdfPCell(new Phrase("Email:"));
           cell5.setBorder(Rectangle.NO_BORDER);
           table7.addCell(cell5);
           
           
           cell7 = new PdfPCell(new Phrase("mithleshpatel887766@gmail.com", font));
           cell7.setBorder(Rectangle.NO_BORDER);
           table7.addCell(cell7);
          
           outerTable.addCell(table7);
           outerTable.addCell(table5);
           document.add(outerTable);
  
          // adding user booking deatils           
          Font font1Tittle = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
          fontTittle.setSize(15);
          Paragraph paragraph2 = new Paragraph("BOOKING DETAILS", font1Tittle);
          paragraph2.setAlignment(Paragraph.ALIGN_LEFT);
          document.add(paragraph2);
          

    Table table = new Table(2);
    table.setWidth(100);
    float[] columnWidths = {0.9f, 0.2f};
    table.setWidths(columnWidths);
    table.setPadding(3);
    table.setBorderColor(CMYKColor.GRAY);
    table.addCell(new Phrase("1 Cheerful 1bedroom house in 3rd floor Rate:"));
    table.addCell(new Phrase("₹2,870"));
    table.addCell(new Phrase("Adults:"));
    table.addCell(new Phrase("2"));
    table.addCell(new Phrase("Children"));
    table.addCell(new Phrase("2"));
    table.addCell(new Phrase("Nights"));
    table.addCell(new Phrase("2"));
    table.addCell(new Phrase("DATES"));
    table.addCell(new Phrase("AMOUNT"));
    table.addCell(new Phrase("February 15, 2024"));
    table.addCell(new Phrase("₹1,300"));
    table.addCell(new Phrase("February 16, 2024"));
    table.addCell(new Phrase("₹1,300"));
    table.addCell(new Phrase("DATES SUBTOTAL"));
    table.addCell(new Phrase("₹2,600"));
    table.addCell(new Phrase("ACCOMMODATION SUBTOTAL "));
    table.addCell(new Phrase("₹2,600"));       
    table.addCell(new Phrase("AMOUNT "));
    table.addCell(new Phrase("FEES"));
    table.addCell(new Phrase("SGST @6%"));
    table.addCell(new Phrase("₹135"));
    table.addCell(new Phrase("CGST @6%"));
    table.addCell(new Phrase("₹135"));
    table.addCell(new Phrase("FEES SUBTOTAL"));
    table.addCell(new Phrase("₹270"));
    table.addCell(new Phrase("TOTAL"));
    table.addCell(new Phrase("₹2,520"));
    document.add(table);

    // adding Payment details
    Font font2Tittle = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
    fontTittle.setSize(15);
    Paragraph paragraph3 = new Paragraph("PAYMENT DETAILS", font2Tittle);
    paragraph3.setAlignment(Paragraph.ALIGN_LEFT);
    document.add(paragraph3); 

    Table table1 = new Table(5);
    table1.setBorderColor(CMYKColor.GRAY);
    table1.setWidth(100);
    table1.addCell(new Phrase("PAYMENT ID"));
    table1.addCell(new Phrase("DATE")); 
    table1.addCell(new Phrase("PAYMENT METHOD"));
    table1.addCell(new Phrase("STATUS"));
    table1.addCell(new Phrase("AMOUNT"));
    table1.addCell(new Phrase("20650"));
    table1.addCell(new Phrase("February 14, 2024"));
    table1.addCell(new Phrase("Phonepe Payments"));
    table1.addCell(new Phrase("Completed"));
    table1.addCell(new Phrase("₹2,520"));
    document.add(table1);
    document.close();
}



}
