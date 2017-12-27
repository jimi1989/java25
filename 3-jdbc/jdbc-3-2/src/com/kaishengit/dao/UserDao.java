package com.kaishengit.dao;

import com.kaishengit.entity.User;
import com.kaishengit.util.DbHelp;

public class UserDao {

	public User findById(int id) {
		String sql = "select * from t_user where id = ?";
		return (User)DbHelp.queryForObject(sql, new UserRowMapper(), id);
	}
	
}
