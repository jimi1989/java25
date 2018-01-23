<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Document</title>
</head>
<body>
	<button id="btn">load json data</button>
	<script>
    	function callback(data) {
    		alert("hello,jsonp");
    		alert(data.id);
    		alert(data.name);
    	}
    </script>
    
	<script src="http://localhost/load.js?m=callback"></script>
   
</body>
</html>