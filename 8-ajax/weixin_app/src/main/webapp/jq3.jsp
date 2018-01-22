<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Document</title>
</head>
<body>
    <input type="text" name="name" id="name"/>
	<button id="btn">save</button>
	
    <script src="/static/js/jquery-1.12.4.js"></script>
    <script>
    	$(function(){
    		$("#btn").click(function(){
    			var username = $("#name").val();
    			$.ajax({
    				url: "/save",
    				type : "post",
    				data : {
    					"name": username
    				},
    				beforeSend:function(){
    					$("#btn").attr("disabled","disabled");
    					$("#btn").text("保存中...");
    				},
    				success:function(data){
    					alert(data);
    				},
    				error:function(){
    					alert("系统繁忙");
    				},
    				complete:function(){
    					$("#btn").removeAttr("disabled");
    					$("#btn").text("保存");
    				}
    			});
    			
    			/* $.post("/save",{"name":$("#name").val()}).done(function(data){
    				alert(data);
    			}); */
    		})
    	})
    </script>
</body>
</html>