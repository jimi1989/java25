<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Document</title>
</head>
<body>
	<button id="btn">load xml data</button>
	
	
    <script src="/static/js/jquery-1.12.4.js"></script>
    <script>
    	$(function(){
    		$.getJSON("/load.js?m=?",function(data){
    			alert(data.id);
    		});
    		
    	})
    		
    </script>
</body>
</html>