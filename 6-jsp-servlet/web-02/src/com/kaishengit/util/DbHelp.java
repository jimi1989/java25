package com.kaishengit.util;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import com.kaishengit.exception.DataAccessException;

public class DbHelp {

	private static QueryRunner runner = new QueryRunner();

	/**
	 * ÷¥––insert delete update
	 */
	public static void executeUpdate(String sql, Object... params) {
		Connection conn = ConnectionManager.getConnection();
		try {
			System.out.println("SQL:" + sql);
			runner.update(conn, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn);
		}
	}

	public static <T> T query(String sql, ResultSetHandler<T> rsh, Object... params) {
		Connection conn = ConnectionManager.getConnection();
		try {
			System.out.println("SQL:" + sql);
			return runner.query(conn, sql, rsh, params);
		} catch (SQLException e) {
			throw new DataAccessException("÷¥––" + sql + "“Ï≥£", e);
		} finally {
			close(conn);
		}
	}

	private static void close(Connection conn) {
		try {
			if (conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
