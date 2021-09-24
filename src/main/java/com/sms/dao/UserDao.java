package com.sms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.sms.model.StudentCoursesJoin;
import com.sms.model.User;
import com.sms.model.enums.UserType;
import com.sms.utils.DatabaseConnection;

public class UserDao implements Dao<User> {
	private static Connection con = DatabaseConnection.getConnection();

	
	public List<User> users = new ArrayList<>();
	@Override
	public Optional<User> get(User user) {
		// TODO Auto-generated method stub
		StringBuilder queryBuilder = new StringBuilder(
				"Select name,username,password,type FROM user WHERE username = ? AND password = ? ");

		PreparedStatement ps;
		try {
			ps = con.prepareStatement(queryBuilder.toString());
			if (user.getUserName() != null && !user.getUserName().isBlank() && user.getPassword() != null
					&& !user.getPassword().isBlank()) {

				ps.setString(1, user.getUserName());
				ps.setString(2, user.getPassword());
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					return Optional.of(new User(rs.getString("name"), rs.getString("username"),
							rs.getString("password"), UserType.valueOfLabel(rs.getString("type"))));

				}

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		ArrayList<User> user = new ArrayList<User>();

		// TODO Auto-generated method stub
		StringBuilder queryBuilder = new StringBuilder(
				"select * from  user");

		PreparedStatement ps;
		try {
			ps = con.prepareStatement(queryBuilder.toString());
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				user.add(new User(rs.getString("Name"), rs.getString("username"),
						rs.getString("password"),UserType.valueOfLabel(rs.getString("type"))));
			}

			return user;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public boolean save(User user) {
		// TODO Auto-generated method stub
		ArrayList<User> usersList = (ArrayList<User>) getAll();
		boolean flag = false;
		for(User eachUser : usersList) {
			if(eachUser.getUserName().equalsIgnoreCase(user.getUserName()))
			{
				flag = true;
			}
		}
		if(!flag) {
		StringBuilder queryBuilder = new StringBuilder(
				"INSERT INTO user(name,username,password,type) VALUES (?,?,?,?) ");
		
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(queryBuilder.toString());
			ps.setString(1, user.getName());
			ps.setString(2, user.getUserName());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getType().toString());
			int rs = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		}
	
		return flag;
	}
	

	@Override
	public void update(User user, String[] params) {
		// TODO Auto-generated method stub
		
		StringBuilder queryBuilder = new StringBuilder(
				"UPDATE user SET name = ? WHERE username = ?  ");
		
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(queryBuilder.toString());
			ps.setString(1, user.getUserName());
			ResultSet rs = ps.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(User t) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<User> getAll(User t) {
		return null;
		// TODO Auto-generated method stub
		
	}

}
