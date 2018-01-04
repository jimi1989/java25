<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户登录</title>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css" />
</head>
<body>
    
    <div class="container">
    
    	<div class="row">
    		<div class="col-md-7">
    			<form action="/login" method="post" id="loginForm">
		    		<legend>用户登录</legend>
		    		<%
		    			String error = request.getParameter("error");
		    			if("1001".equals(error)){
		    				
		    		%>
						<div class="alert alert-danger">用户名或者密码错误，请重新输入</div>
					<%
		    			}
					%>		    		
		    		
		    		<div class="form-group">
		    			<label>帐号:</label>
		    			<input type="text" name="userName" class="form-control"/>
		    		</div>
		    		<div class="form-group">
		    			<label>密码:</label>
		    			<input type="password" name="pass" class="form-control"/>
		    		</div>
		    		
		    	</form>
    			<button class="btn btn-primary" id="loginBtn">登录</button>
    		</div>
    	
    	</div>
    
    </div>
    <script src="/static/js/jquery-3.2.1.js"></script>
	<script src="/static/js/jquery.validate.js"></script>
    <script>
    	$(function(){
    		$("#loginForm").validate({
    			errorClass : "text-danger",
				errorElement:'span',
				rules:{
					userName:{
						required : true,
						minlength : 3
					},
					pass:{
						required : true,
						rangelength : [6,12]
					}
				},
				messages :{
					userName:{
						required : "请输入用户名",
						minlength : "用户名至少3位"
					},
					pass:{
						required : "请输入密码",
						rangelength : "密码6-12位"
					}
				}
    			
    			
    			
    		});
    		
    		$("#loginBtn").click(function(){
    			$("#loginForm").submit();
    		});
    	});
    
    </script>
</body>
</html>