package com.kaishengit.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;



public class JdbcTest1 {

	public static void main(String[] args) {

		String driver = "com.mysql.jdbc.Driver";
//		String url = "jdbc:mysql://IP:端口/数据库名称";
		String url = "jdbc:mysql://127.0.0.1:3306/db_25";
		String name = "root";
		String password = "rootroot";
		
		try {
			// 1.加载数据库驱动
			Class.forName(driver);
			
			// 2.获取数据库连接
			Connection conn = DriverManager.getConnection(url, name, password);
			
			// 3.执行sql
			String sql = "insert into t_user (name, address, tel) values (?, ?, ?)";
//			String sql = "update t_user set tel = 111 where id = 6";
//			String sql = "delete from t_user where id = 5";
			
//			Statement stat = conn.createStatement();
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setString(1, "gedern");
			pstat.setString(2, "houston");
			pstat.setString(3, "115");
			
			pstat.executeUpdate();
//			stat.executeUpdate(sql); // insert update delete
			
			// 4.释放资源
			pstat.close();
			conn.close();
			
			
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
