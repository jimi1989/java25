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
    				String name = (String)request.getAttribute("name");
    				String author = (String)request.getAttribute("author");
    				String publish = (String)request.getAttribute("publish");
    				String isbn = (String)request.getAttribute("isbn");
    				String num = (String)request.getAttribute("num");
    				String message = (String)request.getAttribute("message");
    				
    				name = (name == null ? "" : name);
    				author = (author == null ? "" : author);
    				publish = (publish == null ? "" : publish);
    				isbn = (isbn == null ? "" : isbn);
    				num = (num == null ? "" : num);
    				if(message != null) {
    				
    			%>
    			<div class="alert alert-danger"><%= message %></div>
    			<%
    				}
    			%>
    		
    			<form action="/add" method="post" id="addForm">
    				<div class="form-group">
    					<label>书籍名称</label>
    					<input type="text" name="name" value="<%=name %>" class="form-control" />
    				</div>
    				<div class="form-group">
    					<label>书籍作者</label>
    					<input type="text" name="author" value="<%=author %>" class="form-control" />
    				</div>
    				<div class="form-group">
    					<label>书籍出版社</label>
    					<input type="text" name="publish" value="<%=publish %>" class="form-control" />
    				</div>
    				<div class="form-group">
    					<label>ISBN</label>
    					<input type="text" name="isbn" value="<%=isbn %>" class="form-control" />
    				</div>
    				<div class="form-group">
    					<label>书籍数量</label>
    					<input type="text" name="num" value="<%=num %>" class="form-control" />
    				</div>
    			</form>
    			<button class="btn btn-primary" id="addBtn">新增</button>
    		</div>	
    	</div>
    </div>
    
    <script src="/static/js/jquery-3.2.1.js"></script>
    <script>
    	$(function(){
    		$("#addBtn").click(function(){
    			$("#addForm").submit();
    		});
    	});
    
    
    </script>
</body>
</html>