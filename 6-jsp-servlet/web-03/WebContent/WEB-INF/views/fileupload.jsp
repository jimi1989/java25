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
    
    	<h5>文件上传的表单的method属性必须是post</h5>
    	<h5>文件上传的表单控件使用的是input元素的type属性为file</h5>
    	<h5>设置文件上传表单的form元素的enctype属性的值为multipart/form-data</h5>
    	<div class="row">
    		<div class="col-md-5">
    			<form action="/upload" method="post" enctype="multipart/form-data">
			    	<div class="form-group">
			    		<input type="text" name="desc" class="form-control"/>
			    		<br/>
			    		<input type="file" name="file1"/>
			    	</div>
			    	<button class="btn btn-primary">文件上传</button>
			    </form>
    		</div>
    	</div>
    </div>
    
</body>
</html>