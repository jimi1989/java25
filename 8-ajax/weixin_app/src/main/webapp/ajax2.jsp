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
    
    <script src="/static/js/ajax.js"></script>
    <script>
    	//var $ = ....;
    	(function(){
    		var input = document.getElementById("name");
    		var span = document.getElementById("check");
    		var xmlHttp = $.createXmlHttp();
    		input.onchange = function(){
    			//解决将参数进行URLEncode编码
    			xmlHttp.open("get","/ajax2?name=" + encodeURIComponent(input.value));
    			// 在send之前设置回调函数
    			xmlHttp.onreadystatechange = function(){
    				if(xmlHttp.readyState == 4) {
    					if(xmlHttp.status == 200) {
	    					// 获取服务端返回的数据
	    					var data = xmlHttp.responseText;
	    					alert(data);
    						if(data == "yes") {
    							span.innerText = "√";
    						} else {
    							span.innerText = "X";
    						} 
    						
    					}
    				}
    				
    			}
    			xmlHttp.send();
    		}
    		
    		
    	})();
    </script>
</body>
</html>