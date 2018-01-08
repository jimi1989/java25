package com.kaishengit.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.kaishengit.dao.BookDao;
import com.kaishengit.entity.Book;
import com.kaishengit.exception.ServiceException;

/**
 * 该类用于处理book相关的业务逻辑
 * @author jimi_jin
 *
 */
public class BookService {
	
	BookDao bookDao = new BookDao();
	/**
	 * @param name 书籍名称
	 * @param author 书籍作者
	 * @param publish 书籍出版社
	 * @param isbn isbn
	 * @param num 数量
	 * @throws ServiceException 当isbn重复的时候抛出该异常
	 */
	public void addBook(String name, String author, String publish, String isbn, String num)
			throws ServiceException{
		
		// 2.1 判断isbn是否存在
		Book book = bookDao.findByIsbn(isbn);
		
		if(book == null) {
			// 3.封装到entity对象
			book = new Book();
			book.setName(name);
			book.setAuthor(author);
			book.setPublish(publish);
			book.setIsbn(isbn);
			book.setTotal(Integer.parseInt(num));
			book.setCurrentNum(Integer.parseInt(num));
			
			// 4.调用dao执行保存操作
			bookDao.save(book);
		} else {
			// 手动抛出异常
			throw new ServiceException("ISBN重复");
		}
		
	}

	/**
	 * 查找书籍列表
	 * @return 书籍列表
	 */
	public List<Book> findAllBook() {
		return bookDao.findAll();
	}

	public void delBook(String id) {

		if(StringUtils.isNumeric(id)) {
			Book book = bookDao.findById(id);
			if(book != null) {
				//TODO 判断书籍有无借出
				bookDao.delById(id);
			} else {
				throw new ServiceException("参数异常");
			}
		} else {
			throw new ServiceException("参数异常");
		}
		
		
	}

	/**
	 * 根据id查找书籍
	 * @param id
	 * @return
	 */
	public Book findBookById(String id) {
		return bookDao.findById(id);
	}

	/**
	 * 更新书籍信息
	 * @param name
	 * @param author
	 * @param publish
	 * @param isbn
	 * @param total
	 * @param currentNum
	 * @param currentNum2 
	 */
	public void updateBook(String id,String name, String author, String publish, String isbn, String total, String currentNum) {
		
		Book book = new Book();
		
		book.setId(Integer.parseInt(id));
		book.setName(name);
		book.setAuthor(author);
		book.setPublish(publish);
		book.setIsbn(isbn);
		book.setTotal(Integer.parseInt(total));
		book.setCurrentNum(Integer.parseInt(currentNum));
		
		bookDao.update(book);
		
	}
	
}
