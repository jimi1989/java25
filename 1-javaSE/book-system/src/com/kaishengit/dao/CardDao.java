package com.kaishengit.dao;

import org.apache.commons.dbutils.handlers.BeanHandler;

import com.kaishengit.entity.Card;
import com.kaishengit.util.DbHelp;

public class CardDao {

	public Card findByCode(String code) {
		String sql = "select * from t_card where code = ?";
		return DbHelp.query(sql, new BeanHandler<Card>(Card.class), code);
	}

	public void save(Card card) {
		String sql = "insert into t_card (code, name, tel) values (?,?,?)";
		DbHelp.executeUpdate(sql, card.getCode(), card.getName(),card.getTel());
	}

}
