<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Document</title>
</head>
<link rel="stylesheet" href="/static/css/bootstrap.css" />
<body>
    <div class="container">
    	<a href="/add" class="btn btn-primary">新增书籍</a>
    	<a href="/logout" class="btn btn-default">退出登录</a>
    	<table class="table">
			<thead>
				<tr>
					<th>书籍名称</th>
					<th>书籍作者</th>
					<th>出版社</th>
					<th>ISBN</th>
					<th>总数量</th>
					<th>当前数量</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				
				<c:forEach items="${bookList}" var="book">
					<tr>
						<td>${book.name }</td>
						<td>${book.author }</td>
						<td>${book.publish }</td>
						<td>${book.isbn }</td>
						<td>${book.total }</td>
						<td>${book.currentNum }</td>
						<td><a href="javascript:;" rel="${book.id }" class="del">删除</a>
							<a href="/update?id=${book.id }">修改</a>
						</td>
					</tr>
				</c:forEach>
				
			</tbody>   	
    	</table>
    
    </div>
    
    <script src="/static/js/jquery-3.2.1.js"></script>
    <script src="/static/js/layer/layer.js"></script>
    <script>
    	$(function(){
    		$(".del").click(function(){
	    		var id = $(this).attr("rel");
	    		layer.confirm("确定要删除么？",function(){
	    			// /del?id=1 修改浏览器地址栏的url
					location.href="/del?id="+id;
	    		});
    			/* if(confirm("确认要删除么?")){
					// /del?id=1 修改浏览器地址栏的url
					location.href="/del?id="+id;
    			} */
    		})
    	});
    
    
    </script>
    
</body>
</html>