package com.kaishengit.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.kaishengit.entity.Account;
import com.kaishengit.util.DbHelp;
import com.kaishengit.util.RowMapper;

public class AccountDao {

	public void save(Account acc) {
		String sql = "insert into t_account (name,password) values (?,?)";
		DbHelp.executeUpdate(sql,acc.getName(), acc.getPassword());
	}

	public void update(Account acc) {
		String sql = "update t_account set name = ? , password = ? where id = ?";
		DbHelp.executeUpdate(sql, acc.getName(),acc.getPassword(),acc.getId());
	}

	public void delete(int id) {
		String sql = "delete from t_account where id = ?";
		DbHelp.executeUpdate(sql, id);
	}

	public Account findById(int id) {
		String sql = "select id, name, password from t_account where id = ?";
		return (Account)DbHelp.queryForObject(sql, new AccountRowMapper(), id);
	}

	public Account findByNameAndPassword(String accName, String accPassword) {
		String sql = "select id, name, password from t_account where name = ? and password = ?";
		return (Account)DbHelp.queryForObject(sql, new AccountRowMapper(), accName, accPassword);

	}

	@SuppressWarnings("unchecked")
	public List<Account> findAll() {
		String sql = "select * from t_account";
		return DbHelp.queryForList(sql, new AccountRowMapper());
	}
	
	private class AccountRowMapper implements RowMapper{

		@Override
		public Object mapperRow(ResultSet rs) throws SQLException {
			Account acc = new Account();
			acc.setId(rs.getInt(1));
			acc.setName(rs.getString(2));
			acc.setPassword(rs.getString(3));
			return acc;
		}

	}
}


