package com.project;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.sendRedirect("index.html");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("full_name");
        String rollno = request.getParameter("roll_number");
        String dept = request.getParameter("department");
        String email = request.getParameter("email");

        // ✅ ADD THIS
        String type = request.getParameter("publication_type");
        String title = request.getParameter("title");
        String journal = request.getParameter("journal_name");
        String date = request.getParameter("publication_date");
        
        
        try {

            int studentId = StudentDAO.insertStudent(name, rollno, dept, email);

            PublicationDAO.insertPublication(type, title, journal, date, studentId, 0);

            response.sendRedirect("Student.html?success=1");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}