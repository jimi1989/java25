<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <link rel="stylesheet" href="/static/css/bootstrap.css" />
</head>
<body>
    <div class="container">
   	<%
   		pageContext.setAttribute("age", 12); // 当前页面
   		int age = (Integer)pageContext.getAttribute("age");
    	String name = (String)request.getAttribute("name"); // 一次请求响应期间
    	String address = (String)session.getAttribute("address");  // 会话期间
    	String status = (String)application.getAttribute("status"); // 容器启动期间
    %>
    
    <h4><%=age %></h4>
    <h4><%=name %></h4>
    <h4><%=address %></h4>
    <h4><%=status %></h4>
    </div>
    
</body>
</html>