package com.kaishengit.dao;

import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.kaishengit.entity.Book;
import com.kaishengit.util.DbHelp;

public class BookDao {

	public void save(Book book) {
		String sql = "insert into t_book (name,author,publish,isbn,total,currentNum) values (?,?,?,?,?,?)";
		DbHelp.executeUpdate(sql, book.getName(),book.getAuthor(),book.getPublish(),book.getIsbn(),book.getTotal(),book.getCurrentNum());
	}

	public Book findByIsbn(String isbn) {
		String sql = "select * from t_book where isbn = ?";
		return DbHelp.query(sql, new BeanHandler<>(Book.class), isbn);
	}

	public List<Book> findAll() {
		String sql ="select * from t_book";
		return DbHelp.query(sql, new BeanListHandler<>(Book.class));
	}

	public void delById(String id) {
		String sql = "delete from t_book where id = ?";
		DbHelp.executeUpdate(sql, id);
	}

	public Book findById(String id) {
		String sql = "select * from t_book where id = ?";
		return DbHelp.query(sql, new BeanHandler<>(Book.class), id);
	}

	public void update(Book book) {
		String sql = "update t_book set name = ?, author = ?, publish = ?, isbn = ?, total = ?, currentNum = ? where id = ?";
		DbHelp.executeUpdate(sql, book.getName(),book.getAuthor(),book.getPublish(),book.getIsbn(),book.getTotal(),book.getCurrentNum(),book.getId());
	}
	
}		
