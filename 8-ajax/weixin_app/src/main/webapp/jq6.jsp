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
	<table class="table">
		<thead>
			<tr>
				<td>id</td>
				<td>name</td>
				<td>age</td>
			</tr>
		</thead>
		<tbody id="res">
			
		</tbody>
	</table>
	
    <script src="/static/js/jquery-1.12.4.js"></script>
    <script>
    	$(function(){
    		$("#btn").click(function(){
    			$.get("/user.json").done(function(json){
   					console.log(json.length);
   					for(var i = 0; i < json.length; i++) {
   						var user = json[i];
   						var tr = "<tr><td>" + user.id + "</td><td>" + user.name + "</td><td>" + user.age + "</td></tr>"
           				$("#res").append(tr);
   					}
        				
        		});
    		});
    		
    	})
    		
    </script>
</body>
</html>