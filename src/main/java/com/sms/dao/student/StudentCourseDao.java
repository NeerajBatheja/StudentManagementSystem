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
import com.sms.model.StudentCourse;
import com.sms.model.User;
import com.sms.utils.DatabaseConnection;

public class StudentCourseDao implements Dao<StudentCourse> {
	private static Connection con = DatabaseConnection.getConnection();

	@Override
	public Optional<StudentCourse> get(StudentCourse id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StudentCourse> getAll(User user) {
		
		ArrayList<StudentCourse> studentcourse = new ArrayList<StudentCourse>();
		StudentCourse sc = new StudentCourse();
		 
		// TODO Auto-generated method stub
		StringBuilder queryBuilder = new StringBuilder("select * from courses INNER JOIN student_courses_join ON courses.course_code = student_courses_join.course_code WHERE student_courses_join.username = ? ");
		
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(queryBuilder.toString());
			ps.setString(1,user.getUserName());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				studentcourse.add(new StudentCourse(rs.getString("course_name"), rs.getString("course_code"),rs.getString("course_desc")));
			}
			
			return studentcourse;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return studentcourse;

	
		
	}

	@Override
	public boolean save(StudentCourse sc) {
		boolean flagAddCourse = false;
		// TODO Auto-generated method stub
		User user = new User();
		user.setUserName(sc.getUsername());
		List<StudentCourse> registeredCourseList = getAll(user);
			for(StudentCourse studentcourse : registeredCourseList) {
			
				if(sc.getCourseCode().equalsIgnoreCase(studentcourse.getCourseCode()) ) {
					flagAddCourse = true;
				}
				
			}
		
		if(!flagAddCourse) {
				StringBuilder queryBuilder = new StringBuilder(
						"INSERT  INTO student_courses_join (username,course_code,status) VALUES (?,?,?) ");
				PreparedStatement ps;
				try {
					ps = con.prepareStatement(queryBuilder.toString());
					ps.setString(1, sc.getUsername());
					ps.setString(2, sc.getCourseCode());
					ps.setString(3, "Fee Pending");
					int rs = ps.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} }
	
		return flagAddCourse;
	} 

	@Override
	public void update(StudentCourse t, String[] params) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(StudentCourse t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<StudentCourse> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
