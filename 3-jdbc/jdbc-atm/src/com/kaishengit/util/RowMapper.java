package com.kaishengit.util;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RowMapper<T> {

	T mapperRow(ResultSet rs) throws SQLException;
	
}
