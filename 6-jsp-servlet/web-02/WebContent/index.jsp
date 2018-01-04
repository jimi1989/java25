<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/static/css/bootstrap.css" />
<style>
	/* .error {
		color : red;
	} */
</style>
</head>
<body>
	
	<div class="container">
		<div class="panel panel-primary">
		<div class="panel-heading">
			<h3>用户注册</h3>
		</div>
	
		<div class="panel-body">
			<form action="/add" id="addForm">
				<div class="form-group">
					<label>用户名</label>
					<input type="text" name="userName" class="form-control" />
				</div>
				<div class="form-group">
					<label>密码</label>
					<input type="text" name="password" id="pwd"  class="form-control" />
				</div>
				<div class="form-group">
					<label>确认密码</label>
					<input type="text" name="rePassword" class="form-control" />
				</div>
				<div class="form-group">
					<label>邮箱</label>
					<input type="text" name="email" class="form-control" />
				</div>
				<div class="form-group">
					<label>年龄</label>
					<input type="text" name="age" class="form-control" />
				</div>
			
			</form>
		
			<div class="panel-footer">
				<button type="button" class="btn btn-primary" id="addBtn">注册</button>
			</div>
		</div>
	
	
	</div> 
	
	</div>
	
	
	<script src="/static/js/jquery-3.2.1.js"></script>
	<script src="/static/js/jquery.validate.js"></script>
	<!-- <script src="/static/js/messages_zh.js"></script> -->
	
	<script>
		$(function(){
			$("#addForm").validate({
				
				errorClass : "text-danger",
				errorElement:'span',
				rules:{
					userName:{
						required : true,
						minlength : 3
					},
					password:{
						required : true,
						rangelength : [6,12]
					},
					rePassword :{
						required : true,
						rangelength : [6,12],
						equalTo : "#pwd"
					},
					email : {
						required : true,
						email : true
					},
					age : {
						required : true,
						digits :true
					}
					
				},
				messages:{
					userName:{
						required : "请输入用户名",
						minlength : "用户名至少3位"
					},
					password:{
						required : "请输入密码",
						rangelength : "密码长度6-12位"
					},
					rePassword:{
						required : "请输入确认密码",
						rangelength : "密码长度6-12位",
						equalTo: "两次密码不一致"
					},
					email : {
						required : "请输入邮箱",
						email : "邮箱格式不正确"
					},
					age : {
						required : "请输入年龄",
						digits: "请输入正确的年龄"
					}
				}
			});
			
			$("#addBtn").click(function(){
				
				$("#addForm").submit();

			});
			

		});
	
	
	</script>
</body>
</html>