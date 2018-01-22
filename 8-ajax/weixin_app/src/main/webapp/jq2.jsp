<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Document</title>
</head>
<body>
    <input type="text" name="username" id="name"/><span id="check"></span>
    
    <script src="/static/js/jquery-1.12.4.js"></script>
    <script>
    	$(function(){
    		$("#name").change(function(){
    			// 发起ajax异步get请求
    			$.get("/ajax22",{"name":$(this).val()}).done(function(data){
    				alert(data);
    			}).error(function(){
    				alert("系统繁忙");
    			});
    			
    			/* $.get("/ajax22",{"name":$(this).val(),"address":"kaifeng"},function(data){
    				alert(data);
    			}); */
    		})
    		;
    	})
    </script>
</body>
</html>