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
   		<form action="/pay" id="payForm" method="post">
   			<div class="form-group">
   				<input type="hidden" name="token" value="${token}"/>
   				<input type="text" class="form-control" name="money" id="money"/>
   			</div>
			<button class="btn btn-primary">支付</button>
   		</form>
   	</div>
</body>
</html>