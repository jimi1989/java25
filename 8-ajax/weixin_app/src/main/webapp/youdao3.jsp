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
    
    <script src="/static/js/jquery-1.12.4.js"></script>
    <script>
    	$(function(){
    		$("#btn").click(function(){
    			$("#result").html("");
    			var input = $("#word").val();
    			var url = "http://fanyi.youdao.com/openapi.do?keyfrom=kaishengit&key=1587754017&type=data&doctype=jsonp&callback=?&version=1.1&q="+input;
    			$.getJSON(url,function(data){
    				var explains = data.basic.explains;
    				for(var i = 0; i < explains.length; i++) {
    					var exWord = explains[i];
    					var p = "<p>" + exWord + "</p>"
    					$("#result").append(p);
    				}
    			});
    			
    			
    		})
    		
    		
    	})
    
    </script>
    
</body>
</html>