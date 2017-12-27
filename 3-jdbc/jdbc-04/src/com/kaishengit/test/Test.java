package com.kaishengit.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class Test {

	public static void main(String[] args) throws Exception {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://127.0.0.1:3306/db_25";
		String username = "root";
		String password = "rootroot";
		
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, username, password);
		
		String sql = "select id,name as username, password as userpassword, money from t_Account";
		PreparedStatement pstat = conn.prepareStatement(sql);
		
		ResultSet rs = pstat.executeQuery();
		
		ResultSetMetaData rsmd = rs.getMetaData();
		// 结果集列的数量
		int columnCount =  rsmd.getColumnCount();
		
		while(rs.next()) {
			for(int i = 1; i <= columnCount; i++) {
				// 获取列名
				String columnLabel = rsmd.getColumnLabel(i);
				// 根据列名获得对应的值
				Object obj = rs.getObject(columnLabel);
				// 根据列名获取对应的设值方法名
				String methodName = "set" + columnLabel.substring(0,1).toUpperCase() + columnLabel.substring(1);
				System.out.println(columnLabel + "-->" + obj + "-->" + methodName);
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		System.out.println("count:" + columnCount);
		
		/*for (int i = 1; i <= columnCount; i++) {
//			String columnName = rsmd.getColumnName(i);
//			System.out.println(columnName);
			String columnLabel = rsmd.getColumnLabel(i);
			System.out.println(columnLabel);
		}*/
		
		
		
		/*while(rs.next()) {
			int id = rs.getInt(1);
			String name = rs.getString(2);
			System.out.println("id:" + id + " ,name:" + name);
		}*/
		
		rs.close();
		pstat.close();
		conn.close();
	}

}
