package com.project;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/FacultyServlet")
public class FacultyServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.sendRedirect("index.html");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("full_name");
        String fid = request.getParameter("faculty_id");
        String dept = request.getParameter("department");
        String designation = request.getParameter("designation");
        String email = request.getParameter("email");

        // ✅ ADD THIS
        String type = request.getParameter("publication_type");
        String title = request.getParameter("title");
        String journal = request.getParameter("journal_name");
        String date = request.getParameter("publication_date");

        try {

            int facultyId = FacultyDAO.insertFaculty(name, fid, dept, designation, email);

            PublicationDAO.insertPublication(type, title, journal, date, 0, facultyId);

            response.sendRedirect("Faculty.html?success=1");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}