<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>凯盛软件CRM-首页</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <%@ include file="../include/css.jsp"%>
    <link rel="stylesheet" href="/static/plugins/uploader/webuploader.css">
    <style>
        tr{
            height: 50px;
            line-height: 50px;
        }
        .table>tbody>tr>td{
            vertical-align: middle;
        }
        .file_icon {
            font-size: 30px;
        }
        .table>tbody>tr:hover{
            cursor: pointer;
        }
        .webuploader-container {
            display: inline-block;
        }
        .webuploader-pick {
            padding: 5px 10px;
            overflow: visible;
            font-size: 12px;
            line-height:1.5;
            font-weight: 400;
        }
    </style>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<!-- Site wrapper -->
<div class="wrapper">
 	<%@ include file="../include/header.jsp"%>
   <jsp:include page="../include/sider.jsp">
   		<jsp:param value="disk_home" name="param"/>
   	</jsp:include>
    <!-- =============================================== -->

    <!-- 右侧内容部分 -->
    <div class="content-wrapper">

        <!-- Main content -->
        <section class="content">

            <!-- Default box -->
            <div class="box">
                <div class="box-header with-border">
                    <h3 class="box-title">${disk.name }</h3>

                    <div class="box-tools pull-right">
                    	<c:if test="${not empty disk}">
	                        <a href="/disk/home?pid=${disk.pId}" class="btn btn-default btn-sm"><i class="fa fa-arrow-left"></i> 返回上一级</a>
                    	</c:if>
                    	<c:choose>
                    		<c:when test="${disk.type == 'file' }">
								<a href="" class="btn btn-info btn-sm"><i class="fa fa-download"></i> 下载</a>                    			
                    		</c:when>
                    		<c:otherwise>
		                    	<div id="picker"><i class="fa fa-upload"></i> 上传文件</div>
		                        <button id="addFolderBtn" class="btn btn-success btn-sm"><i class="fa fa-plus"></i> 新建文件夹</button>
                    		</c:otherwise>	
                    	</c:choose>
                    </div>
                </div>
                <div class="box-body no-padding">

                    <table class="table table-hover">
                    	<c:choose>
                    		<c:when test="${disk.type == 'file' }">
                    			<tr>
                    				<td colspan="4">
                    					<c:choose>
                    						<c:when test="${disk.name.endsWith('.pdf') or disk.name.endsWith('.jpg') or disk.name.endsWith('.gif') or disk.name.endsWith('.jpeg')}">
				                    			<a href="/disk/download?id=${disk.id}" target="" class="btn btn-default btn-sm"><i class="fa fa-search"></i> 预览</a>
				                    			<a href="/disk/download?id=${disk.id}&fileName=${disk.name}" class="btn btn-info btn-sm"><i class="fa fa-download"></i> 下载</a>          
                    						</c:when>
                    						<c:otherwise>
				                    			<a href="/disk/download?id=${disk.id}&fileName=${disk.name}" class="btn btn-info btn-sm"><i class="fa fa-download"></i> 下载</a>          
                    						</c:otherwise>
                    					
                    					</c:choose>
                    				</td>
                    			</tr>
                    		</c:when>
                    		<c:otherwise>
                    			<c:if test="${empty diskList}">
		                    		<tr><td colspan="5">暂无内容</td></tr>
		                    	</c:if>
		                    	<c:forEach items="${diskList}" var="disk">
			                        <tr class="tr" rel="${disk.id }">
			                        	<c:choose>
			                        		<c:when test="${disk.type == 'dir' }">
					                            <td width="50" class="file_icon"><i class="fa fa-folder-o"></i></td>
			                        		</c:when>
			                        		<c:otherwise>
					                            <td width="50" class="file_icon"><i class="fa fa-file-o"></i></td>
			                        		</c:otherwise>
			                        	</c:choose>
			                            <td>${disk.name}</td>
			                            <td><fmt:formatDate value="${disk.updateTime}" pattern="yyyy年MM月dd日 HH:mm:ss"/></td>
			                            <td width="100">${disk.fileSize}</td>
			                            <td width="150">
			                                <div class="btn-group">
			                                    <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
			                                        <i class="fa fa-ellipsis-h"></i>
			                                    </button>
			                                    <ul class="dropdown-menu">
				                                    <c:choose>
						                        		<c:when test="${disk.type == 'dir' }">
								                            <li><a href="/disk/home?pid=${disk.id}">打开</a></li>
						                        		</c:when>
						                        		<c:otherwise>
								                           <li><a href="">下载</a></li>
						                        		</c:otherwise>
						                        	</c:choose>
			                                        
			                                        <li><a href="#">重命名</a></li>
			                                        <li><a href="#">删除</a></li>
			                                    </ul>
			                                </div>
			                            </td>
			                        </tr>
		                    	</c:forEach>
                    		</c:otherwise>
                    	</c:choose>
                    
                    	
                    	
                    </table>


                </div>
                <!-- /.box-body -->
            </div>
            <!-- /.box -->

        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->

    <!-- 底部 -->
 <%@ include file="../include/footer.jsp"%>
</div>
<!-- ./wrapper -->

 <%@ include file="../include/js.jsp"%>
 <script type="text/javascript" src="/static/plugins/uploader/webuploader.js"></script>
 <script>
 	$(function(){
 		var pid = "${requestScope.disk == null? '0' : requestScope.disk.id}";
 		$("#addFolderBtn").click(function(){
 			layer.prompt({title:"请输入文件夹名称:"},function(text, index){
 				layer.close(index);
 				$.post("/disk/new/folder",{"pid":pid, "name":text}).done(function(resp){
                    if(resp.state == 'success') {
                        layer.msg("创建成功");
                        history.go(0);
                    } else {
                        layer.msg(resp.message);
                    }
                }).error(function(){
                    layer.msg("服务器异常");
                });
 			});
 		});
 		
 		$(".tr").click(function(){
 			var pid = $(this).attr("rel");
 			window.location.href = "/disk/home?pid=" + pid;
 		});
 		

 		//文件上传
        var uploader = WebUploader.create({
            pick:"#picker",
            swf:'/static/plugins/uploader/Uploader.swf',
            server:'/disk/upload', //上传服务器
            auto: true, //自动上传
            fileVal:'file', //上传文件的表单控件的名称 name属性
            formData:{
                "pid":pid
            } //发送请求给服务器的额外数据
        });
 		
        var loadIndex = -1;
        //开始上传
        uploader.on('uploadStart',function (file) {
            loadIndex = layer.load(2); // 2 :加载的样式
        });
        
        //上传成功
        uploader.on('uploadSuccess',function (file,resp) {
            if(resp.state == 'success') {
                layer.msg("文件上传成功");
                history.go(0);
            }
        });
        //上传失败
        uploader.on('uploadError',function (file) {
            layer.msg("上传失败，服务器异常");
        });
        //无论上传成功还是失败
        uploader.on('uploadComplete',function (file) {
            layer.close(loadIndex);
        });
 		
 	})
 
 </script>
</body>
</html>
