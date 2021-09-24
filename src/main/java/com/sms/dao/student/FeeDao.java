package com.sms.dao.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.sms.dao.Dao;
import com.sms.model.Fee;
import com.sms.model.User;
import com.sms.model.enums.UserType;
import com.sms.utils.DatabaseConnection;

public class FeeDao implements Dao<Fee> {
	private static Connection con = DatabaseConnection.getConnection();

	@Override
	public Optional<Fee> get(Fee fee) {
		// TODO Auto-generated method stub
		StringBuilder queryBuilder = new StringBuilder("select * FROM fee WHERE course_code = ? ");

		PreparedStatement ps;
		try {
			ps = con.prepareStatement(queryBuilder.toString());

			ps.setString(1, "C1234");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Optional<Fee> coursefee =  Optional.of(new Fee(rs.getString("fee_amount"), rs.getString("course_code")));
				return coursefee;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<Fee> getAll(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Fee> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean save(Fee t) {
		return false;
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Fee t, String[] params) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Fee t) {
		// TODO Auto-generated method stub

	}

}
