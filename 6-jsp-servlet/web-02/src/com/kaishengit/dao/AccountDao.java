package com.kaishengit.dao;

import org.apache.commons.dbutils.handlers.BeanHandler;

import com.kaishengit.entity.Account;
import com.kaishengit.util.DbHelp;

public class AccountDao {

	public Account findByName(String userName) {
		
		String sql = "select * from t_Account where name = ?";
		return DbHelp.query(sql, new BeanHandler<>(Account.class), userName);
		
	}

}
