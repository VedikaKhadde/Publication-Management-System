package com.project;

import java.sql.*;

public class FacultyDAO {

    public static int insertFaculty(String name, String fid, String dept, String designation, String email) {

        int facultyId = 0;

        try {
            Connection con = DBConnection.getConnection();

            String query = "INSERT INTO faculty(full_name, faculty_id, department, designation, email) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setString(1, name);
            ps.setString(2, fid);
            ps.setString(3, dept);
            ps.setString(4, designation);
            ps.setString(5, email);

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                facultyId = rs.getInt(1);
            }

            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return facultyId;
    }
}