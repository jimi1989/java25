package com.kaishengit.dao;

import java.util.List;

import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.kaishengit.entity.Message;
import com.kaishengit.util.DbHelp;
import com.mysql.jdbc.StringUtils;

public class MessageDao {

	public List<Message> findByMaxId(String maxId) {
		String sql = null;
		if(StringUtils.isStrictlyNumeric(maxId)) {
			sql = "select * from t_message where id > ? order by id desc";
			return DbHelp.query(sql, new BeanListHandler<>(Message.class),maxId);
		} else {
			sql = "select * from t_message order by id desc";
			return DbHelp.query(sql, new BeanListHandler<>(Message.class));
		}
	}

}
