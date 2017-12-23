package com.kaishengit.dao;

import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.kaishengit.entity.Book;
import com.kaishengit.entity.BookCard;
import com.kaishengit.util.DbHelp;

public class BookCardDao {

	public int countBorrowNum(int cid) {
		String sql = "select count(*) from t_book_card where cid = ?";
		return DbHelp.query(sql, new ScalarHandler<Long>(), cid).intValue();
	}

	public BookCard findByBidAndCid(int bid, int cid) {
		String sql = "select bid,cid from t_book_card where bid = ? and cid = ?";
		return DbHelp.query(sql, new BeanHandler<BookCard>(BookCard.class), bid, cid);
	}

	public void save(int bid, int cid) {
		String sql = "insert into t_book_card (bid, cid) values (?,?)";
		DbHelp.executeUpdate(sql, bid, cid);
	}

	public List<Book> findBorrowBookList(int cid) {
//		String sql = "select bookname,authorname,publishname,isbn from t_book as b, t_book_card as bc where b.id = bc.bid and cid = ? ";
		String sql = "select * from t_book where id in (select bid from t_book_card where cid = ?)";
		
		return DbHelp.query(sql, new BeanListHandler<Book>(Book.class), cid);
	}

	public void delete(int bid, int cid) {
		String sql = "delete from t_book_card where bid = ? and cid = ?";
		DbHelp.executeUpdate(sql, bid, cid);
	}
	
}
