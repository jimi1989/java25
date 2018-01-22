<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Document</title>
</head>
<body>
    <button id="btn">loadData</button>
    
    <script src="/static/js/ajax.js"></script>
    <script>
    	(function(){
			var xmlHttp = kaisheng.createXmlHttp();
    		var btn = document.querySelector("#btn");
			btn.onclick = function(){
				xmlHttp.open("get","https://www.baidu.com");
				xmlHttp.onreadystatechange = function(){
					var data = xmlHttp.responseText;
					console.log(data);
				}
				xmlHttp.send();
			}    		
    		
    	})();
    
    </script>
    
    
</body>
</html>