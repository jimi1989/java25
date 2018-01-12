package com.kaishengit.dao;

import org.apache.commons.dbutils.handlers.BeanHandler;

import com.kaishengit.entity.Admin;
import com.kaishengit.util.DbHelp;

public class AdminDao {

	public Admin findByName(String userName) {
		String sql = "selects * from t_admin where name = ?";
		return DbHelp.query(sql, new BeanHandler<>(Admin.class), userName);
	}

}
