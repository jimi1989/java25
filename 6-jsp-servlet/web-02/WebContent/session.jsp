
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
    	session.setMaxInactiveInterval(2); // 单位是s
		String sessionID = session.getId();  
		long time = session.getCreationTime();
		
		
    %>
    <h4><%=sessionID %></h4>
    <h4><%=time %></h4>
</body>
</html>