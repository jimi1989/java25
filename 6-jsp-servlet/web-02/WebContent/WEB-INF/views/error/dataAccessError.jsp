<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Document</title>
</head>
<body>
    <h4>数据库访问异常</h4>
    <%
    	String message = exception.getMessage();
    	Integer code = (Integer)request.getAttribute("javax.servlet.error.status_code");
    	// sendMessage(message) ,发送电子邮件、短信到管理员
    %>
    
    <%=message %>
    <%=code %>
</body>
</html>