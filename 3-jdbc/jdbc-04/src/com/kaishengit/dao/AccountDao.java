package com.kaishengit.dao;

import com.kaishengit.entity.Account;
import com.kaishengit.util.BeanRowMapper;
import com.kaishengit.util.DbHelp;

public class AccountDao {

	public Account findById(int id){
		String sql = "select id, name, password, money, enable from t_account where id = ?";
		return DbHelp.queryForObject(sql, new BeanRowMapper<Account>(Account.class), id);
	}
	
	
}
