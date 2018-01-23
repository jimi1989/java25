<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <link rel="stylesheet" href="/static/css/bootstrap.css" />
</head>
<body>
	<div class="container">
		<div id="newalert" class="alert alert-danger" style="display:none"><a id="text" href="javascript:;"></a></div>
		<ul class="list-group" id="weibo">
			
		</ul>
	
	
	</div>
	
	
    <script src="/static/js/jquery-1.12.4.js"></script>
    <script>
    	$(function(){
    		var maxId = null;
    		var newMessage = null;
    		$.get("/message").done(function(data){
    			for(var i = 0; i < data.length; i++) {
    				// 找到当前数据中id的最大值
    				maxId = data[0].id;
    				var li = "<li class='list-group-item'>" + data[i].message + "</li>";
    				$("#weibo").append(li);
    			}
    			
    		}).error(function(){
    			alert("系统异常")
    		});
    		
    		setInterval(function(){
    			$.get("/message",{"maxId": maxId}).done(function(data){
        			if(data.length > 0) {
        				$("#text").text("有" + data.length + "条新微博");
        				$("#newalert").show();
        				newMessage = data;
        			}
        			
        		}).error(function(){
        			alert("系统异常")
        		});
    			
    		},5000);
    		
    		$("#text").click(function(){
    			// alert框消失
    			$("#newalert").hide();
    			// 添加数据
    			for(var i =  newMessage.length - 1; i >= 0; i--) {
	    			// 修改maxid
					maxId= newMessage[0].id;
	    			
    				var li = "<li class='list-group-item'>" + newMessage[i].message + "</li>";
    				$("#weibo").prepend(li);
    			}
    		});
    		
    	})
    		
    </script>
</body>
</html>