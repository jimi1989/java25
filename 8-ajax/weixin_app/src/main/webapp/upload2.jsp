<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <link rel="stylesheet" href="/static/css/bootstrap.css" />
    <link rel="stylesheet" href="/static/js/upload/webuploader.css" />
</head>
<body>
    <div class="container">
    	<div class="panel panel-default">
    		<div class="panel-heading">
    			<div id="picker">请选择文件</div>
    			
    		</div>
    		<div class="panel-body" id="body">
    			
    			<div id="result" >
    		
    			</div>
    		</div>
    		
    		
    	</div>
    
    </div>
    
    
    <script src="/static/js/jquery-1.12.4.js"></script>
    <script src="/static/js/upload/webuploader.js"></script>
    <script>
    	$(function(){
    		var uploader = WebUploader.create({
    			// 指定flash文件上传的路径
    			swf:'/static/js/upload/Uploader.swf',
    			// 指定文件上传的服务器地址
    			server : '/file/upload',
    			// 制定文件上传的html控件
    			pick : '#picker',
    			fileVal : 'file',
    			auto: true, //文件自动上传
    			accept : {
    		        title: 'Images',
    		        extensions: 'gif,jpg,jpeg,bmp,png',
    		        mimeTypes: 'image/*'
    		    }
    		});
    		
    		
    		// 文件上传成功事件
    		uploader.on('uploadSuccess', function(file, resp) {
    			if(resp.state == 'success') {
	    			$("<img style='height:100px' />").attr("src",resp.data)
	    				.appendTo($("#result"));
    			}
    			/* uploader.makeThumb(file,function(error, src) {
    		        if (error ) {
    		           alert('不能预览');
    		           return;
    		        }
					var $img = $("<img>");
    		        $img.attr('src', src);
    		        $("#body").append($img);
    		    },100,100); */
    			
    			
    		});

    		
    		uploader.on('startUpload',function(){
    			$("#result").html("");
    		})
    		
    		
    		
    		
    	})
    
    </script>
</body>
</html>