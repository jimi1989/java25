package com.kaishengit.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AddBatchTest {

	public static void main(String[] args) {

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
			
			PreparedStatement pstat = conn.prepareStatement(sql);
			long startTime = System.currentTimeMillis();
			
			for(int i = 0; i < 1000; i++) {
				pstat.setString(1, "gedern" + i);
				pstat.setString(2, "123123");
				// 添加到批处理
				pstat.addBatch();
				
				if(i % 100 == 0) {
					// 每100次循环执行一次批处理
					pstat.executeBatch();
					pstat.clearBatch();
				}
				
			}
			pstat.executeBatch();
			
			
			long endTime = System.currentTimeMillis();
			System.out.println("共消耗：" + (endTime - startTime) + "ms");
			
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
