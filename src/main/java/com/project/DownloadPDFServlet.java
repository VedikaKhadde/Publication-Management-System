package com.project;

import java.io.IOException;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

@WebServlet("/DownloadPDFServlet")
public class DownloadPDFServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "attachment; filename=Publication_Report.pdf");

            Document document = new Document(PageSize.A4);
            PdfWriter.getInstance(document, response.getOutputStream());

            document.open();

            // TITLE
            Font titleFont = new Font(Font.FontFamily.HELVETICA, 20, Font.BOLD);
            Paragraph title = new Paragraph("Publication Report", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            title.setSpacingAfter(10);
            document.add(title);

            // DATE
            Font subFont = new Font(Font.FontFamily.HELVETICA, 12);
            String dateStr = new SimpleDateFormat("dd-MM-yyyy HH:mm").format(new Date());
            Paragraph datePara = new Paragraph("Generated on: " + dateStr, subFont);
            datePara.setAlignment(Element.ALIGN_CENTER);
            datePara.setSpacingAfter(20);
            document.add(datePara);

            // TABLE
            PdfPTable table = new PdfPTable(5);
            table.setWidthPercentage(100);
            table.setWidths(new float[]{2, 4, 4, 3, 5});

            Font headFont = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);

            table.addCell(new PdfPCell(new Phrase("Type", headFont)));
            table.addCell(new PdfPCell(new Phrase("Title", headFont)));
            table.addCell(new PdfPCell(new Phrase("Journal", headFont)));
            table.addCell(new PdfPCell(new Phrase("Date", headFont)));
            table.addCell(new PdfPCell(new Phrase("Student / Faculty", headFont)));

            // FETCH DATA
            ResultSet rs = PublicationDAO.getAllPublications();

            while (rs.next()) {

                table.addCell(rs.getString("publication_type"));
                table.addCell(rs.getString("title"));
                table.addCell(rs.getString("journal_name"));
                table.addCell(rs.getString("publication_date"));

                String studentName = rs.getString("student_name");
                String roll = rs.getString("roll_number");
                String dept = rs.getString("department");

                String facultyName = rs.getString("faculty_name");
                String fid = rs.getString("faculty_id");
                String fdept = rs.getString("faculty_dept");

                // ✅ FINAL CLEAN DISPLAY
                if (roll != null) {
                    table.addCell(
                            "Student: " + studentName +
                            "\nDept: " + dept +
                            "\nRoll No: " + roll
                    );
                } else {
                    table.addCell(
                            "Faculty: " + facultyName +
                            "\nDept: " + fdept +
                            "\nFaculty ID: " + fid
                    );
                }
            }

            document.add(table);

            Paragraph footer = new Paragraph("\n--- End of Report ---");
            footer.setAlignment(Element.ALIGN_CENTER);
            document.add(footer);

            document.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}