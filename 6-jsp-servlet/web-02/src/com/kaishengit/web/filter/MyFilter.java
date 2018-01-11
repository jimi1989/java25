package com.kaishengit.web.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyFilter extends AbstractFilter{
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("hello filter,before...");
		// FilterChain接口中的doFilter()方法就是让请求经过过滤器，并且是请求过滤和响应过滤的分割
		chain.doFilter(request, response);
		System.out.println("hello filter,after...");
	}

}
