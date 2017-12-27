package com.kaishengit.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import java.util.Set;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanMapHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.kaishengit.entity.Account;

public class Test {

	public static void main(String[] args) {
		QueryRunner runner = new QueryRunner();
//		String sql = "insert into t_Account (name,password,money,enable) values(?,?,?,?)";
//		String sql = "select * from t_account where id = ?";
//		String sql = "select * from t_account";
		
//		String sql = "select * from t_account";
		
//		String sql = "select * from t_account";
		
		String sql = "select count(*) from t_account";
		
		Connection conn = ConnectionManager.getConnection();
		try {
			int num = runner.query(conn, sql, new ScalarHandler<Long>()).intValue();
			System.out.println(num);
			
			
//			runner.execute(conn, sql, "jdbc-utils", "123123",100 ,true);
//			Account acc = runner.query(conn, sql, new BeanHandler<Account>(Account.class), 3005);
//			System.out.println(acc);

			/*List<Account> accounts = runner.query(conn, sql, new BeanListHandler<Account>(Account.class));
			for(Account acc : accounts) {
				System.out.println(acc);
			}*/
			
			/*Map<Integer,Account> maps = runner.query(conn, sql, new BeanMapHandler<Integer,Account>(Account.class));
			Set<Integer> sets = maps.keySet();
			for(Integer obj : sets) {
				System.out.println(obj + "--" + maps.get(obj));
			} */
			
			/*Map<String,Object> maps = runner.query(conn, sql, new MapHandler());
			Set<String> sets = maps.keySet();
			for(String obj : sets) {
				System.out.println(obj + "--" + maps.get(obj));
			}*/
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try {
				if(conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
