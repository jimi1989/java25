package com.kaishengit.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class JdbcTest2 {

	public static void main(String[] args) {

		String driver = "com.mysql.jdbc.Driver";  //jdk6.0+
		String url = "jdbc:mysql:///db_25";
		String userName = "root";
		String password = "rootroot";
		
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, userName, password);
			
			String sql = "select id,name,address,tel from t_user where id = 6";
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			while(rs.next()) {
				/*int id = rs.getInt(1);
				String name = rs.getString(2);
				String address = rs.getString(3);
				String tel = rs.getString(4);*/
				
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String address = rs.getString("address");
				String tel = rs.getString("tel");
				
				System.out.println("id:" + id + ", name:" + name + ", address:" + address +" ,tel:" + tel);
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null && !rs.isClosed()) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if(stat != null && !stat.isClosed()) {
						stat.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
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
		
	}

}
