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
    			$.get("/user.xml").done(function(data){
        			$(data).find("user").each(function(){
        				var id = $(this).attr("id");
        				var name = $(this).find("name").text();
        				var age = $(this).find("age").text();
        				var tr = "<tr><td>" + id + "</td><td>" + name + "</td><td>" + age + "</td></tr>"
        				$("#res").append(tr);
        				
        			})
        		});
    		});
    		
    		
    		
    	})
    		
    </script>
</body>
</html>