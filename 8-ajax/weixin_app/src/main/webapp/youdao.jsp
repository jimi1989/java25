<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>翻译</title>
</head>
<body>
    <input type="text" id="word"/> 
    <button id="btn">翻译</button>
    <div id="result"></div>
    
    <script src="/static/js/ajax.js"></script>
    <script>
    	(function(){
    		var xmlHttp = kaisheng.createXmlHttp();
    		var btn = document.querySelector("#btn");
    		var input = document.querySelector("#word");
    		var result = document.querySelector("#result");
    		
    		
    		btn.onclick = function(){
    			result.innerHTML = "";
    			xmlHttp.open("get","/youdao?word=" + input.value);
    			xmlHttp.onreadystatechange = function(){
    				if(xmlHttp.readyState == 4) {
    					if(xmlHttp.status == 200) {
    						// 获得xml文档对象,并解析
    						var xmlDoc = xmlHttp.responseXML;
    						var explain = xmlDoc.getElementsByTagName("explains")[0];
    						var ex = explain.getElementsByTagName("ex")[0].childNodes[0].nodeValue;
    						
    						var text = document.createTextNode(ex);
    						var p = document.createElement("p");
    						p.appendChild(text);
    						result.appendChild(p);
    						
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