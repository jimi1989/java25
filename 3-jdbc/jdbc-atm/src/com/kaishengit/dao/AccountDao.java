package com.kaishengit.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.kaishengit.entity.Account;
import com.kaishengit.util.DbHelp;
import com.kaishengit.util.RowMapper;

public class AccountDao {

	/**
	 * 根据name查询对应的account对象
	 * @param name
	 * @return
	 */
	public Account findByName(String name) {
		String sql = "select * from t_account where name = ?";
		return DbHelp.queryForObject(sql, new AccountRowMapper(), name);
	}

	private class AccountRowMapper implements RowMapper<Account> {

		@Override
		public Account mapperRow(ResultSet rs) throws SQLException {
			Account account = new Account();
			account.setId(rs.getInt(1));
			account.setName(rs.getString(2));
			account.setPassword(rs.getString(3));
			account.setMoney(rs.getInt(4));
			account.setEnable(rs.getBoolean(5));
			
			return account;
		}
		
	}

	public void save(Account account) {
		String sql = "insert into t_account (name, password, money, enable) values (?,?,?,?)";
		DbHelp.executeUpdate(sql, account.getName(), account.getPassword(), account.getMoney(), account.isEnable());
	}

	public void update(Account account) {
		String sql = "update t_account set name = ?, password = ?, money = ?, enable = ? where id = ?";
		DbHelp.executeUpdate(sql, account.getName(), account.getPassword(), account.getMoney(), account.isEnable(), account.getId());
	}

	public List<Account> findAll() {
		String sql = "select * from t_Account";
		return DbHelp.queryForList(sql, new AccountRowMapper());
	}
}
