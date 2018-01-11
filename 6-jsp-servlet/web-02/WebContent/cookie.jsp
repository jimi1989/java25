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
    
    <button class="btn btn-primary" id="add">新增cookie</button>
    <button class="btn btn-primary" id="get">获取cookie</button>
    <button class="btn btn-primary" id="del">删除cookie</button>
    
    <script src="/static/js/jquery-3.2.1.js"></script>
    <script src="/static/js/cookie.js"></script>
    <script>
    	$(function(){
    		$("#add").click(function(){
    			Cookies.set('name', 'jack', { expires: 7, path: '/' });
    			Cookies.set('playid', '1001', { expires: 7, path: '/' });
    		});
    		
			$("#get").click(function(){
				/* var nameValue = Cookies.get('name');
				alert(nameValue); */
				var cookies = Cookies.get();
				alert(cookies.productId);
				alert(cookies.playid);
				alert(cookies.JSESSIONID);
				
   			});
			    		
			$("#del").click(function(){
				Cookies.remove('productId');
			});
    	});
   
    	
    
    </script>
    
</body>
</html>