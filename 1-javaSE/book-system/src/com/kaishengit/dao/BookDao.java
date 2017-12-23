package com.kaishengit.dao;

import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.kaishengit.entity.Book;
import com.kaishengit.util.DbHelp;

public class BookDao {

	public Book findByIsbn(String isbn) {
		String sql = "select * from t_book where isbn = ?";
		return DbHelp.query(sql, new BeanHandler<Book>(Book.class), isbn);
	}

	public void save(Book book) {
		String sql = "insert into t_book (isbn,bookname,authorname, publishname,totalnum,currentnum) values (?,?,?,?,?,?)";
		DbHelp.executeUpdate(sql, book.getISBN(), book.getBookName(), book.getBookAuthor(), book.getPublishName(),book.getTotalNum(), book.getCurrNum());
	}

	public void update(Book book) {
		String sql = "update t_book set bookname = ?, authorname = ?, totalNum = ?, currentNum = ? where id = ? ";
		DbHelp.executeUpdate(sql, book.getBookName(), book.getBookAuthor(), book.getTotalNum(), book.getCurrNum(),book.getId());
	}

	public void delete(int id) {
		String sql = "delete from t_book where id = ?";
		DbHelp.executeUpdate(sql, id);
	}

	public List<Book> findAll() {
		String sql = "select * from t_book";
		return DbHelp.query(sql, new BeanListHandler<Book>(Book.class));
	}

	public List<Book> findByKeys(String keys) {
//		String keyWords = "%" + keys + "%";
//		String sql = "select * from t_book where bookname like ?";
		String sql = "select * from t_book where bookname like concat('%',?,'%')";
		return DbHelp.query(sql, new BeanListHandler<Book>(Book.class), keys);
	}

}
