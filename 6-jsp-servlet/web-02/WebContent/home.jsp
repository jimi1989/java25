<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Document</title>
</head>
<body>
	<% 
		//int num = 10 / 0;
		//String name = request.getParameter("userName");
		String name = (String)request.getAttribute("userName");
		Integer money = (Integer)request.getAttribute("money");
		List<String> lists = (List<String>)request.getAttribute("lists");
	%>
	<h3>登录成功</h3>
    <h3>hello,<%=name %>,您的余额为:<%=money %></h3>
    <span>我的兴趣为:</span>
    <ul>
	    <%
	    	for(String str : lists) {
	    %>
			<li><%=str %></li>	    
	    <%} %>
    </ul>
</body>
</html>