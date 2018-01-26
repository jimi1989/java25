package com.kaishengit.dao;

import org.apache.commons.dbutils.handlers.BeanHandler;

import com.kaishengit.entity.Account;
import com.kaishengit.util.DbHelp;

public class AccountDao {

	public Account findbyByName(String username) {
		String sql = "select * from t_account where username = ?";
		return DbHelp.query(sql, new BeanHandler<>(Account.class), username);
	}

}
