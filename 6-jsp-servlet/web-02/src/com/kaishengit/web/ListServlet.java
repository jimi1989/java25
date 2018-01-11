package com.kaishengit.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kaishengit.entity.Admin;
import com.kaishengit.entity.Book;
import com.kaishengit.service.BookService;

public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BookService bookService = new BookService();

		List<Book> bookList = bookService.findAllBook();

		req.setAttribute("bookList", bookList);
		req.getRequestDispatcher("/WEB-INF/views/list.jsp").forward(req, resp);
	}

}
