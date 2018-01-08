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
    	<div class="row">
    		<div class="col-md-7">
    			<form action="/login" id="loginForm" method="post">
    				<%
    					String message = (String) request.getAttribute("message");
    					String username = (String) request.getAttribute("username");
    					username = (username == null ? "" : username);
    					if(message != null) {
    						
    				%>
    					<div class="alert alert-danger"><%=message %></div>
    				<%} %>
    				
    				<div class="form-group">
    					<label>用户名</label>
    					<input type="text" name="username" value="<%=username %>" class="form-control" />
    				</div>
    				<div class="form-group">
    					<label>密码</label>
    					<input type="password" name="password" class="form-control" />
    				</div>
    			</form>   
    			<button class="btn btn-primary" id="loginBtn">登录</button> 		
    		</div>
    	</div>
    </div>
    
    
    <script src="/static/js/jquery-3.2.1.js"></script>
    <script>
    	$(function(){
    		$("#loginBtn").click(function(){
    			$("#loginForm").submit();
    		});
    	})
    
    </script>
</body>
</html>