package com.kaishengit.test;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

public class DbHelp {

	private static QueryRunner runner = new QueryRunner();

	/**
	 * Ö´ÐÐinsert delete update
	 */
	public static void executeUpdate(String sql, Object... params) {
		Connection conn = ConnectionManager.getConnection();
		try {
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
			return runner.query(conn, sql,rsh ,params);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn);
		}
		return null;
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
