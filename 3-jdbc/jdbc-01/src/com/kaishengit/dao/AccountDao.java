package com.kaishengit.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kaishengit.entity.Account;

public class AccountDao {

	public int save(Account acc) {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://127.0.0.1:3306/db_25";
		String name = "root";
		String password = "rootroot";

		try {
			// 1.加载数据库驱动
			Class.forName(driver);

			// 2.获取数据库连接
			Connection conn = DriverManager.getConnection(url, name, password);

			// 3.执行sql
			String sql = "insert into t_account (name, password) values (?, ?)";

			PreparedStatement pstat = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstat.setString(1, acc.getName());
			pstat.setString(2, acc.getPassword());

			pstat.executeUpdate();

			ResultSet rs = pstat.getGeneratedKeys();

			if (rs.next()) {
				int id = rs.getInt(1);
				return id;
			}

			// 4.释放资源
			pstat.close();
			conn.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public void update(Account acc) {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://127.0.0.1:3306/db_25";
		String name = "root";
		String password = "rootroot";

		try {
			// 1.加载数据库驱动
			Class.forName(driver);

			// 2.获取数据库连接
			Connection conn = DriverManager.getConnection(url, name, password);

			// 3.执行sql
			String sql = "update t_account set name = ?, password = ? where id = ?";

			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setString(1, acc.getName());
			pstat.setString(2, acc.getPassword());
			pstat.setInt(3, acc.getId());

			pstat.executeUpdate();

			// 4.释放资源
			pstat.close();
			conn.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

	public void delete(int id) {

		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://127.0.0.1:3306/db_25";
		String name = "root";
		String password = "rootroot";

		try {
			// 1.加载数据库驱动
			Class.forName(driver);

			// 2.获取数据库连接
			Connection conn = DriverManager.getConnection(url, name, password);

			// 3.执行sql
			String sql = "delete from t_Account where id = ?";

			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setInt(1, id);

			pstat.executeUpdate();

			// 4.释放资源
			pstat.close();
			conn.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public Account findById(int id) {

		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://127.0.0.1:3306/db_25";
		String name = "root";
		String password = "rootroot";

		Account account = null;

		try {
			// 1.加载数据库驱动
			Class.forName(driver);

			// 2.获取数据库连接
			Connection conn = DriverManager.getConnection(url, name, password);

			// 3.执行sql
			String sql = "select id, name, password from t_account where id = ?";

			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setInt(1, id);

			ResultSet rs = pstat.executeQuery();

			if (rs.next()) {
				account = new Account();
				account.setId(rs.getInt("id"));
				account.setName(rs.getString("name"));
				account.setPassword(rs.getString("password"));

			}

			// 4.释放资源
			pstat.close();
			conn.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return account;

	}

	public Account findByNameAndPassword(String accName, String accPassword) {

		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://127.0.0.1:3306/db_25";
		String name = "root";
		String password = "rootroot";

		Account account = null;

		try {
			// 1.加载数据库驱动
			Class.forName(driver);

			// 2.获取数据库连接
			Connection conn = DriverManager.getConnection(url, name, password);

			// 3.执行sql
			String sql = "select id, name, password from t_account where name = ? and password = ?";

			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setString(1, accName);
			pstat.setString(2, accPassword);

			ResultSet rs = pstat.executeQuery();

			if (rs.next()) {
				account = new Account();
				account.setId(rs.getInt("id"));
				account.setName(rs.getString("name"));
				account.setPassword(rs.getString("password"));

			}

			// 4.释放资源
			pstat.close();
			conn.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return account;

	}

	public List<Account> findAll() {

		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://127.0.0.1:3306/db_25";
		String name = "root";
		String password = "rootroot";

		List<Account> accList = new ArrayList<>();
		
		try {
			// 1.加载数据库驱动
			Class.forName(driver);

			// 2.获取数据库连接
			Connection conn = DriverManager.getConnection(url, name, password);

			// 3.执行sql
			String sql = "select id, name, password from t_account";

			PreparedStatement pstat = conn.prepareStatement(sql);

			ResultSet rs = pstat.executeQuery();

			while(rs.next()) {
				Account account = new Account();
				account.setId(rs.getInt("id"));
				account.setName(rs.getString("name"));
				account.setPassword(rs.getString("password"));

				accList.add(account);
			}

			// 4.释放资源
			pstat.close();
			conn.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return accList;

	}
	
	
}
