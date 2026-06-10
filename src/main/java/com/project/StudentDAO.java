package com.project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentDAO {

	public static int insertStudent(String name, String roll, String dept, String email) {

	    int studentId = 0;

	    try {
	        Connection con = DBConnection.getConnection();

	        String sql = "INSERT INTO student(full_name, roll_number, department, email) VALUES (?, ?, ?, ?)";
	        PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

	        ps.setString(1, name);
	        ps.setString(2, roll);
	        ps.setString(3, dept);
	        ps.setString(4, email);

	        ps.executeUpdate();

	        ResultSet rs = ps.getGeneratedKeys();
	        if (rs.next()) {
	            studentId = rs.getInt(1);
	        }

	        ps.close();
	        con.close();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return studentId;
	}
}