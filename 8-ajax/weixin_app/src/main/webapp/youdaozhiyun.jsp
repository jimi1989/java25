<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>我的翻译官	</title>
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
			$.getJSON("/youdaozhiyun",{"p":input},function(data){
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