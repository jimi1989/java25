package com.kaishengit.dao;

import java.util.ArrayList;
import java.util.List;

import com.kaishengit.entity.AccountDept;
import com.kaishengit.util.DbHelp;

public class AccountDeptDao {

	public void save(List<AccountDept> accountDeptLists) {
		String sql = "insert into t_account_dept (account_id,dept_id) values ";
		List<Object> arrays = new ArrayList<>();
		for(AccountDept accountDept : accountDeptLists) {
			sql += "(?,?),"; // values (?,?),(?,?),
			arrays.add(accountDept.getAccountId());
			arrays.add(accountDept.getDeptId());
		}
		
		sql = sql.substring(0, sql.length()-1);
		//Arrays.asList(数组) lists.toArray();
		DbHelp.executeUpdate(sql, arrays.toArray());
		
	}

	/*public void save(AccountDept accountDept) {
		String sql = "insert into t_account_dept (account_id,dept_id) values (?,?)";
		DbHelp.executeUpdate(sql, accountDept.getAccountId(),accountDept.getDeptId());
	}*/

}
