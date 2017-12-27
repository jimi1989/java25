package com.kaishengit.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.kaishengit.entity.User;
import com.kaishengit.util.DbHelp;
import com.kaishengit.util.RowMapper;

public class UserDao {
	DbHelp<User> db = new DbHelp<>();
	
	public User findById(int id) {
		String sql = "select * from t_user where id = ?";
		return db.queryForObject(sql, new UserRowMapper(), id);
	}

	private class UserRowMapper implements RowMapper<User>{

		@Override
		public User mapperRow(ResultSet rs) throws SQLException {
			User user = new User();
			user.setId(rs.getInt(1));
			user.setName(rs.getString(2));
			user.setAddress(rs.getString(3));
			user.setTel(rs.getString(4));
			return user;
		}

	}

	
}
