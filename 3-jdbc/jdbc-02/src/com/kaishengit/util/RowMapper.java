package com.kaishengit.util;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RowMapper {

	Object mapperRow(ResultSet rs) throws SQLException;
	
}
