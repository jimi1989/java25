package com.kaishengit.app;

import java.util.List;
import java.util.Scanner;

import com.kaishengit.dao.AdminDao;
import com.kaishengit.dao.BookCardDao;
import com.kaishengit.dao.BookDao;
import com.kaishengit.dao.CardDao;
import com.kaishengit.entity.Admin;
import com.kaishengit.entity.Book;
import com.kaishengit.entity.BookCard;
import com.kaishengit.entity.Card;

public class App {

	Scanner input = new Scanner(System.in);
	AdminDao adminDao = new AdminDao(); 
	BookDao bookDao = new BookDao();
	CardDao cardDao = new CardDao();
	BookCardDao bookCardDao = new BookCardDao();
	
	public void startup() {
		
		System.out.println("请输入管理员帐号：");
		String name = input.next();
		
		System.out.println("请输入管理员密码：");
		String password = input.next();
		
		Admin admin = adminDao.findByName(name);
		
		if(admin != null && password.equals(admin.getPassword())) {
			System.out.println("登录成功");
			showMenu();
			
		} else {
			System.out.println("帐号或者密码错误，请重新输入");
			startup();
		}
		
		
	}

	private void showMenu() {

		System.out.println("欢迎来到图书管理系统");
		System.out.println("1. 借书");
		System.out.println("2. 还书");
		System.out.println("3. 添加新书");
		System.out.println("4. 更新书籍");
		System.out.println("5. 删除书籍");
		System.out.println("6. 查询所有书籍");
		System.out.println("7. 查询指定书籍");
		System.out.println("8. 新增图书证");
		System.out.println("9. 退出");
		System.out.println("请选择:");

		int index = input.nextInt();
		
		if(1 == index) {
			borrowBook();
		} else if(2 == index) {
			returnBook();
		} else if(3 == index) {
			addBook();
		} else if(4 == index) {
			updateBook();
		} else if(5 == index) {
			deleteBook();
		} else if(6 == index) {
			showAllBooks();
		} else if(7 == index) {
			showQueryBooks();
		} else if(8 == index) {
			addCard();
		} else if(9 == index) {
			System.exit(0);
		} else {
			System.out.println("输入有误，请重新输入");
		}
		
		showMenu();
		
	}

	/**
	 * 还书
	 */
	private void returnBook() {
		// 1. 用户输入借书证号码
		System.out.println("请输入图书证号码:");
		String code = input.next();
		
		// 2. 判断该号码是否存在
		Card card = cardDao.findByCode(code);
		
		if(card != null) {
			List<Book> bookList = bookCardDao.findBorrowBookList(card.getId());
			
			// 3. 展示借阅列表
			System.out.println("书籍名称\t\t作者\t\t出版社\t\t ISBN");
			
			if(bookList.isEmpty()) {
				System.out.println("暂无数据");
			}
			
			for(Book book : bookList) {
				System.out.println(book);
			}
			
			// 4. 输入要还的书籍的isbn
			System.out.println("请输入要还书籍的isbn");
			String isbn = input.next();
			
			Book book = bookDao.findByIsbn(isbn);
			
			// 5. 校验该书籍是否借阅
			if(book != null) {
				BookCard bookCard = bookCardDao.findByBidAndCid(book.getId(), card.getId());
				if(bookCard != null) {
					// 6. 办理还书
					// 6.1. 删除card、book的借阅关系
					bookCardDao.delete(book.getId(), card.getId());
					// 6.2. 更新库存
					book.setCurrNum(book.getCurrNum() + 1);
					bookDao.update(book);
					
					System.out.println("还书成功");
				} else {
					System.out.println("该书籍不存在借阅关系，请查询后重新输入");
				}
			} else {
				System.out.println("该书籍不存在");
			}
			
			
		} else {
			System.out.println("该图书证不存在，请检查后再输入");
		}
		
	}

	/**
	 * 借书
	 */
	private void borrowBook() {
		// 1. 用户输入借书证号码
		System.out.println("请输入图书证号码:");
		String code = input.next();
		
		// 2. 判断该号码是否存在
		Card card = cardDao.findByCode(code);
		
		if(card != null) {
			// 3. 判断该图书证是否已达上限(5)
			int num = bookCardDao.countBorrowNum(card.getId());
			if(num < 5) {
				// 4. 用户输入isbn,并判断该书籍属否存在
				System.out.println("请输入书籍isbn");
				String isbn = input.next();
				
				Book book = bookDao.findByIsbn(isbn);
				
				if(book != null) {
					// 5. 判断该书籍是否处于借阅状态
					BookCard bookCard = bookCardDao.findByBidAndCid(book.getId(), card.getId());
					
					if(bookCard == null) {
						// 6. 判断该书库存是否>0
						if(book.getCurrNum() > 0) {
							// 7. 办理借阅
							// 7.1 建立card、book的借阅关系
							bookCardDao.save(book.getId(), card.getId());
							
							// 7.2 更新库存
							book.setCurrNum(book.getCurrNum() - 1);
							bookDao.update(book);
							
							System.out.println("借阅成功");
						} else {
							System.out.println("库存不足");
						}
					} else {
						System.out.println("该图书已经处于借阅状态，不得二次借阅");
					}
					
				} else {
					System.out.println("该书籍不存在");
				}
				
			} else {
				System.out.println("该图书证借阅数量已达上限");
			}
			
		} else {
			System.out.println("该图书证不存在，请检查后再输入");
		}
		
	}

	/**
	 * 新增图书证
	 */
	private void addCard() {

		System.out.println("请输入图证号码:");
		String code = input.next();
		
		Card card = cardDao.findByCode(code);
		if(card == null) {
			System.out.println("请输入学生姓名:");
			String name = input.next();
			
			System.out.println("请输入联系电话:");
			String tel = input.next();
			
			card = new Card();
			card.setCode(code);
			card.setName(name);
			card.setTel(tel);
			
			cardDao.save(card);
			System.out.println("图书证新建成功");
			
		} else {
			System.out.println("证件号码已存在，请重新输入:");
			addCard();
		}
		
		
	}

	/**
	 * 查询指定书籍
	 */
	private void showQueryBooks() {
		System.out.println("请输入要查找的关键字:");
		String keys = input.next();
		
		List<Book> bookList = bookDao.findByKeys(keys);
		System.out.println("书籍名称\t\t作者\t\t出版社\t\t ISBN \t\t总数量\t\t库存");
		
		if(bookList.isEmpty()) {
			System.out.println("暂无数据");
		}
		
		for(Book book : bookList) {
			System.out.println(book);
		}
		
	}

	/**
	 * 查询所有书籍
	 */
	private void showAllBooks() {

		List<Book> bookList = bookDao.findAll();
		
		System.out.println("书籍名称\t\t作者\t\t出版社\t\t ISBN \t\t总数量\t\t库存");
		
		if(bookList.isEmpty()) {
			System.out.println("暂无数据");
		}
		
		for(Book book : bookList) {
			System.out.println(book);
		}
		
	}

	/**
	 * 删除书籍
	 */
	private void deleteBook() {

		System.out.println("请输入isbn码:");
		String isbn = input.next();
		
		Book book = bookDao.findByIsbn(isbn);
		
		if(book != null) {
			// 如果该书籍被借出，则不能删除
			if(book.getTotalNum() == book.getCurrNum()) {
				 bookDao.delete(book.getId());
				 System.out.println("删除成功！");
			} else {
				System.out.println("该书籍已被借出，不能删除");
			}
			
		} else {
			System.out.println("该书籍不存在");
		}
		
		
	}

	/**
	 * 更新书籍
	 */
	private void updateBook() {

		System.out.println("请输入书籍的isbn码:");
		String isbn = input.next();
		
		Book book = bookDao.findByIsbn(isbn);
		
		if(book != null) {
			System.out.println("是否需要修改书籍的名称?(Y|N)");
			String answer = input.next();
			boolean flag = false;
			
			if(answer.equalsIgnoreCase("y")) {
				System.out.println("请输入新的书籍名称:");
				String bookName = input.next();
				book.setBookName(bookName);
				flag = true;
			}
			
			System.out.println("是否要修改书籍的作者名称?(Y|N)");
			answer = input.next();
			
			if(answer.equalsIgnoreCase("y")) {
				System.out.println("请输入新的作者名称:");
				String authorName = input.next();
				book.setBookAuthor(authorName);
				flag = true;
			}
			
			
			System.out.println("是否要修改书籍的总量?(Y|N)");
			answer = input.next();
			if(answer.equalsIgnoreCase("y")) {
				System.out.println("请输入新的书籍总量");
				int totalNum = input.nextInt();
				int changeNum = totalNum - book.getTotalNum();
				int currentNum = book.getCurrNum() + changeNum;
				if(currentNum >= 0) {
					book.setTotalNum(totalNum);
					book.setCurrNum(currentNum);
					flag = true;
				} else {
					System.out.println("数据库存数量不足，不能修改");
				}
				
			}
			if(flag) {
				bookDao.update(book);
				System.out.println("更新成功");
			}
			
			
		} else {
			System.out.println("该书籍不存在");
		}
		
	}

	/**
	 * 添加新书
	 */
	private void addBook() {
		
		System.out.println("请输入书籍ISBN码");
		String isbn = input.next();
		
		Book book = bookDao.findByIsbn(isbn);
		if(book == null) {
			System.out.println("请输入书籍名称");
			String name = input.next();
			
			System.out.println("请输入书籍作者姓名");
			String authorName = input.next();
			
			System.out.println("请输入书籍出版社名称");
			String publishName = input.next();
			
			System.out.println("请输入书籍总量");
			int totalNum = input.nextInt();
			
			book = new Book();
			book.setISBN(isbn);
			book.setBookAuthor(authorName);
			book.setBookName(name);
			book.setPublishName(publishName);
			book.setTotalNum(totalNum);
			book.setCurrNum(totalNum);
			
			bookDao.save(book);
			
			System.out.println("保存成功");
			
		} else {
			System.out.println("该书籍已经录入，请勿再次录入");
		}
		
	}
}
