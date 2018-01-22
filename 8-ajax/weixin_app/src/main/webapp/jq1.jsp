<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Document</title>
</head>
<body>
    <button type="button" id="btn">sendAjax</button>
    
    <script src="/static/js/jquery-3.2.1.js"></script>
    <script>
    	$(function(){
    		$("#btn").click(function(){
    			// 发起ajax异步get请求
    			$.get("/ajax");
    		});
    	})
    </script>
</body>
</html>