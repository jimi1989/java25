package com.kaishengit.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kaishengit.entity.Admin;
import com.kaishengit.entity.Book;
import com.kaishengit.service.BookService;

public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");

		BookService bookService = new BookService();
		Book book = bookService.findBookById(id);

		if (book != null) {
			// 请求转发到update.jsp
			req.setAttribute("book", book);
			req.getRequestDispatcher("/WEB-INF/views/update.jsp").forward(req, resp);
		} else {
			resp.sendError(404, "参数异常");
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 2.接收表单的值
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String author = req.getParameter("author");
		String publish = req.getParameter("publish");
		String isbn = req.getParameter("isbn");
		String total = req.getParameter("total");
		String currentNum = req.getParameter("currentNum");

		BookService service = new BookService();

		service.updateBook(id, name, author, publish, isbn, total, currentNum);

		// 重定向到/list
		resp.sendRedirect("/list");
	}
}
