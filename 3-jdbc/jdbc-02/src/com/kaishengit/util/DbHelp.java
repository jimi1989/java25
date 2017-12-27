package com.kaishengit.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DbHelp {

	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql:///db_25";
	private static final String NAME = "root";
	private static final String PASSWORD = "rootroot";

	private static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, NAME, PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * 执行insert delete update 
	 */
	public static void executeUpdate(String sql, Object... params) {
		Connection conn = null;
		PreparedStatement pstat = null;
		try {
			conn = getConnection();
			pstat = conn.prepareStatement(sql);

			for (int i = 0; i < params.length; i++) {
				pstat.setObject(i + 1, params[i]);
			}

			pstat.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstat, conn);
		}

	}

	/**
	 * 查询单个对象	
	 */
	public static Object queryForObject(String sql, RowMapper mapper, Object... params) {
		Connection conn = null;
		PreparedStatement pstat = null;
		ResultSet rs = null;
		
		Object obj = null;
		try {
			conn = getConnection();
			pstat = conn.prepareStatement(sql);
			
			for(int i = 0; i < params.length; i++) {
				pstat.setObject(i + 1, params[i]);
			}
			
			rs = pstat.executeQuery();
			
			if(rs.next()) {
				obj = mapper.mapperRow(rs);
			}
			
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstat, conn);
		}
		
		return obj;
	}
	
	
	/**
	 * 查询多个对象
	 */
	@SuppressWarnings("rawtypes")
	public static List queryForList(String sql, RowMapper mapper, Object... params) {
		
		Connection conn = null;
		PreparedStatement pstat = null;
		ResultSet rs = null;
		
		List list = new ArrayList();
		try {
			conn = getConnection();
			pstat = conn.prepareStatement(sql);
			
			for(int i = 0; i < params.length; i++) {
				pstat.setObject(i + 1, params[i]);
			}
			
			rs = pstat.executeQuery();
			
			while(rs.next()) {
				Object obj = mapper.mapperRow(rs);
				list.add(obj);
			}
			
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstat, conn);
		}
		
		return list;
	} 
	
	private static void close(ResultSet rs, Statement pstat, Connection conn) {
		
		try {
			if(rs != null && !rs.isClosed()) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstat, conn);
		}
		
	}

	
	private static void close(Statement stat, Connection conn) {
		try {
			if (stat != null && !stat.isClosed()) {
				stat.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
