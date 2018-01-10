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
    		
    			<form action="/update" method="post" id="updateForm">
    				<input type="hidden" name="id" value="${book.id }" class="form-control" />
    				<div class="form-group">
    					<label>书籍名称</label>
    					<input type="text" name="name" value="${book.name}" class="form-control" />
    				</div>
    				<div class="form-group">
    					<label>书籍作者</label>
    					<input type="text" name="author" value="${book.author }" class="form-control" />
    				</div>
    				<div class="form-group">
    					<label>书籍出版社</label>
    					<input type="text" name="publish" value="${book.publish }" class="form-control" />
    				</div>
    				<div class="form-group">
    					<label>ISBN</label>
    					<input type="text" name="isbn" value="${book.isbn }" class="form-control" />
    				</div>
    				<div class="form-group">
    					<label>总数量</label>
    					<input type="text" name="total" value="${book.total }" class="form-control" />
    				</div>
    				<div class="form-group">
    					<label>当前数量</label>
    					<input type="text" name="currentNum" value="${book.currentNum }" class="form-control" />
    				</div>
    			</form>
    			<button class="btn btn-primary" id="updateBtn">修改</button>
    		</div>	
    	</div>
    </div>
    
    <script src="/static/js/jquery-3.2.1.js"></script>
    <script>
    	$(function(){
    		$("#updateBtn").click(function(){
    			$("#updateForm").submit();
    		});
    	});
    
    
    </script>
</body>
</html>