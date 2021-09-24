package com.sms.dao.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.sms.dao.Dao;
import com.sms.model.Course;
import com.sms.model.User;
import com.sms.model.enums.UserType;
import com.sms.utils.DatabaseConnection;

public class CourseDao implements Dao<Course> {
	private static Connection con = DatabaseConnection.getConnection();

	@Override
	public Optional<Course> get(Course course_id) {
		// TODO Auto-generated method stub
		StringBuilder queryBuilder = new StringBuilder("Select * FROM courses WHERE course_id = ? ");

		PreparedStatement ps;
		try {
			ps = con.prepareStatement(queryBuilder.toString());
			if (course_id != null) {

				ps.setInt(1, 1);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					return Optional.of(new Course(rs.getString("course_name"), rs.getString("course_code"),
							rs.getString("course_desc")));
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<Course> getAll() {
		ArrayList<Course> course = new ArrayList<Course>();

		// TODO Auto-generated method stub
		StringBuilder queryBuilder = new StringBuilder(
				"select * from courses  ");

		PreparedStatement ps;
		try {
			ps = con.prepareStatement(queryBuilder.toString());
		//	ps.setString(1, "neeraj4@gmail.com");
			//ps.setString(2, null);
			//ps.setString(3, " ");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				course.add(new Course(rs.getString("course_name"), rs.getString("course_code"),
						rs.getString("course_desc")));
			}
			
			return course;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public boolean save(Course course) {
		ArrayList<Course> coursesList = (ArrayList<Course>) getAll();
		boolean flag = false;
		for(Course eachCourse : coursesList) {
			
			if(eachCourse.getCourseCode().equalsIgnoreCase(course.getCourseCode())) {
				flag = true;
			}
		}
		// TODO Auto-generated method stub
		if(!flag) {
			StringBuilder queryBuilder = new StringBuilder(
					"INSERT INTO courses (course_name,course_code,course_desc) VALUES (?,?,?) ");
			PreparedStatement ps;
			try {
				ps = con.prepareStatement(queryBuilder.toString());
				ps.setString(1, course.getCourseName());
				ps.setString(2, course.getCourseCode());
				ps.setString(3, course.getCourseDesc());
				int rs = ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return flag;
	}
	

	@Override
	public void update(Course course, String[] params) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Course t) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Course> getAll(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}