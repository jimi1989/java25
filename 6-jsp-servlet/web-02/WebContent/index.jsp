<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		List<String> strList = new ArrayList<>();
		String username = "jack";
		
		//for(int i = 0; i < 10; i++) {
	%>
	
	<!-- 客户端注释：本公司长期招聘前端工程师，详情咨询hr@163.com -->
	<%-- 服务器注释：方法的定义使用声明的方式 --%>
	<%!
		public void add() {
		
		}
	%>
	
	<h3>hello,<%=username %></h3>
	<%= strList.size() %>
	<%
		//}
	%>
</body>
</html>