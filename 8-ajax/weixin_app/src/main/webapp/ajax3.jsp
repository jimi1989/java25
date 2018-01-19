<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Document</title>
</head>
<body>


	<input type="text" name="username" id="name"/>
	<button id="btn">save</button>
    <script src="/static/js/ajax.js"></script>
    <script>
    	//var $ = ....;
    	(function(){
    		var input = document.getElementById("name");
			var btn = document.getElementById("btn");   		
    		
    		var xmlHttp = $.createXmlHttp();
    		btn.onclick = function(){
    			xmlHttp.open("post","/save");
    			xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded")
    			//回调函数必须在发送之前设置
    			xmlHttp.onreadystatechange = function(){
    				if(xmlHttp.readyState == 4) {
    					if(xmlHttp.status == 200) {
    						var data = xmlHttp.responseText;
    						alert(data);
    					} else {
    						alert("系统繁忙，请稍后再试");
    					}
    				}
    				
    				
    			}
    			xmlHttp.send("name=" + input.value);
    		}
    		
    		
    	})();
    </script>
</body>
</html>