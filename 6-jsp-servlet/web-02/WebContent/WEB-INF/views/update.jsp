<%@page import="com.kaishengit.entity.Book"%>
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
    			<%
					Book book = (Book) request.getAttribute("book");    				
    			%>
    		
    			<form action="/update" method="post" id="updateForm">
    				<input type="hidden" name="id" value="<%=book.getId() %>" class="form-control" />
    				<div class="form-group">
    					<label>书籍名称</label>
    					<input type="text" name="name" value="<%=book.getName() %>" class="form-control" />
    				</div>
    				<div class="form-group">
    					<label>书籍作者</label>
    					<input type="text" name="author" value="<%=book.getAuthor() %>" class="form-control" />
    				</div>
    				<div class="form-group">
    					<label>书籍出版社</label>
    					<input type="text" name="publish" value="<%=book.getPublish() %>" class="form-control" />
    				</div>
    				<div class="form-group">
    					<label>ISBN</label>
    					<input type="text" name="isbn" value="<%=book.getIsbn() %>" class="form-control" />
    				</div>
    				<div class="form-group">
    					<label>总数量</label>
    					<input type="text" name="total" value="<%=book.getTotal() %>" class="form-control" />
    				</div>
    				<div class="form-group">
    					<label>当前数量</label>
    					<input type="text" name="currentNum" value="<%=book.getCurrentNum() %>" class="form-control" />
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