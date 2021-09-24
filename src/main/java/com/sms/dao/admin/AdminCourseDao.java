package com.sms.dao.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.sms.dao.Dao;
import com.sms.model.Course;
import com.sms.model.StudentCoursesJoin;
import com.sms.model.User;
import com.sms.utils.DatabaseConnection;

public class AdminCourseDao implements Dao<StudentCoursesJoin> {
	private static Connection con = DatabaseConnection.getConnection();

	@Override
	public Optional<StudentCoursesJoin> get(StudentCoursesJoin id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StudentCoursesJoin> getAll(User user) {
		// TODO Auto-generated method stub
		ArrayList<StudentCoursesJoin> coursesjoin = new ArrayList<StudentCoursesJoin>();

		// TODO Auto-generated method stub
		StringBuilder queryBuilder = new StringBuilder(
				"select * from  student_courses_join WHERE student_courses_join.username = ? ");

		PreparedStatement ps;
		try {
			ps = con.prepareStatement(queryBuilder.toString());
			ps.setString(1, user.getUserName());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				coursesjoin.add(new StudentCoursesJoin(rs.getString("username"), rs.getString("course_code"),
						rs.getString("status")));
			}

			return coursesjoin;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public boolean save(StudentCoursesJoin t) {
		return false;
		// TODO Auto-generated method stub

	}

	@Override
	public void update(StudentCoursesJoin studentcoursejoin, String[] params) {
		// TODO Auto-generated method stub
		StringBuilder queryBuilder = new StringBuilder(
				"UPDATE student_courses_join SET status = ? WHERE username = ? AND course_code = ? ");
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(queryBuilder.toString());
			ps.setString(1, studentcoursejoin.getStatus());
			ps.setString(2, studentcoursejoin.getUsername());
			ps.setString(3, studentcoursejoin.getCourseCode());
			int rs = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(StudentCoursesJoin t) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<StudentCoursesJoin> getAll() {
		// TODO Auto-generated method stub
		ArrayList<StudentCoursesJoin> coursesjoin = new ArrayList<StudentCoursesJoin>();

		// TODO Auto-generated method stub
		StringBuilder queryBuilder = new StringBuilder("select * from  student_courses_join ");

		PreparedStatement ps;
		try {
			ps = con.prepareStatement(queryBuilder.toString());

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				coursesjoin.add(new StudentCoursesJoin(rs.getString("username"), rs.getString("course_code"),
						rs.getString("status")));
			}

			return coursesjoin;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

}
