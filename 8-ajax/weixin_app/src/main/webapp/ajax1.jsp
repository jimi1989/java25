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
    
    <script>
    	(function(){
    		// 创建xmlHttpRequest对象
    		var xmlHttp = null;
    		if(window.ActiveXObject) {
    			// IE浏览器获得ajax引擎
    			xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
    		} else {
    			// 非IE浏览器获得ajax引擎
    			xmlHttp = new XMLHttpRequest();
    		}
    		
    		var btn = document.getElementById("btn");
        	btn.onclick = function(){
        		// 指定请求方式，发送地址
        		xmlHttp.open('get','/ajax');
        		//xmlHttp.open('get','/ajax?_=' + new Date().getTime());
        		// 发送
        		xmlHttp.send();
        	}
    		
    	})();
    </script>
</body>
</html>