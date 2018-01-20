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
	
	
    <script src="/static/js/ajax.js"></script>
    <script>
    	(function(){
			var btn = document.getElementById("btn");   		
    		
    		var xmlHttp = $.createXmlHttp();
    		btn.onclick = function(){
    			xmlHttp.open("get","https://www.baidu.com/s?ie=utf-8&f=8&rsv_bp=0&rsv_idx=1&tn=baidu&wd=java&rsv_pq=f6f9ebad00007e06&rsv_t=57fdZAD1c1rM%2BjxI0u5vJATMhaQ95KaMdeuAxaIs8TL%2BDOeLJetpYVp%2F%2Bhg&rqlang=cn&rsv_enter=1&rsv_sug3=3&rsv_sug1=1&rsv_sug7=100&rsv_sug2=0&inputT=1363&rsv_sug4=2179");
    			xmlHttp.onreadystatechange = function(){
    				if(xmlHttp.readyState == 4) {
    					if(xmlHttp.status == 200) {
    						// 获得xml文档对象,并解析
    						var xmlDoc = xmlHttp.responseText;
    						console.log("html:" + xmlDoc);
    						
    					} else {
    						alert("服务器开小差了...")
    					}
    				}
    			}
    			xmlHttp.send();
    		}
    		
    		
    	})();
    </script>
</body>
</html>