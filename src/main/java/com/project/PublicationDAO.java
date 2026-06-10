package com.project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PublicationDAO {

    public static void insertPublication(String type, String title, String journal, String date, int studentId, int facultyId) {

        try {
            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO publication(publication_type, title, journal_name, publication_date, student_id, faculty_id) VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, type);
            ps.setString(2, title);
            ps.setString(3, journal);
            ps.setString(4, date);

            if (studentId != 0) {
                ps.setInt(5, studentId);
            } else {
                ps.setNull(5, java.sql.Types.INTEGER);
            }

            if (facultyId != 0) {
                ps.setInt(6, facultyId);
            } else {
                ps.setNull(6, java.sql.Types.INTEGER);
            }

            ps.executeUpdate();

            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    public static ResultSet getAllPublications() {

        ResultSet rs = null;

        try {
            Connection con = DBConnection.getConnection();

            String sql = "SELECT p.publication_type, p.title, p.journal_name, p.publication_date, " +
                    "s.full_name AS student_name, s.roll_number, s.department, " +
                    "f.full_name AS faculty_name, f.faculty_id, f.department AS faculty_dept " +
                    "FROM publication p " +
                    "LEFT JOIN student s ON p.student_id = s.id " +
                    "LEFT JOIN faculty f ON p.faculty_id = f.id";

            PreparedStatement ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return rs;
    }
}