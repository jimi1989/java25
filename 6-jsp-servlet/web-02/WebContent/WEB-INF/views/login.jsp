<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
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
    				<c:if test="${not empty param.callback}">
	    				<div class="alert alert-danger">请登录后继续访问</div>
    				</c:if>
    				
    				<c:if test="${not empty message}">
	    				<div class="alert alert-danger">${message }</div>
    				</c:if>
    				
    				<div class="form-group">
    					<label>用户名</label>
    					<input type="hidden" name="callback" value="${param.callback}"/>
    					<input type="text" name="username" value="${username}" id="username" class="form-control" />
    				</div>
    				<div class="form-group">
    					<label>密码</label>
    					<input type="password" name="password" class="form-control" />
    				</div>
    				<div class="checkbox">
    					<label>
    						<input type="checkbox" name="rememberme" value="rememberme" id="rememberme"/> 记住帐号
    					</label>
    				</div>
    				
    			</form>   
    			<button class="btn btn-primary" id="loginBtn">登录</button> 		
    		</div>
    	</div>
    </div>
    
    
    <script src="/static/js/jquery-3.2.1.js"></script>
    <script src="/static/js/cookie.js"></script>
    <script>
    	$(function(){
    		/* $("#username").val(Cookies.get("username")); */
    		
    		$("#loginBtn").click(function(){
    			/* if($("#rememberme")[0].checked){
    				alert("checked");
    			} */
    			/* if($("#rememberme").is(":checked")) {
    				Cookies.set("username",$("#username").val(),{ expires: 7, path: '/' })
    			} */
    			
    			$("#loginForm").submit();
    		});
    	})
    
    </script>
</body>
</html>