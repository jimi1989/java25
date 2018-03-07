<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>凯盛软件CRM-首页</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <%@ include file="../include/css.jsp"%>
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
                    <h3 class="box-title">公司网盘</h3>

                    <div class="box-tools pull-right">
                        <button class="btn btn-primary btn-sm"><i class="fa fa-upload"></i> 上传文件</button>
                        <button id="addFolderBtn" class="btn btn-success btn-sm"><i class="fa fa-plus"></i> 新建文件夹</button>
                    </div>
                </div>
                <div class="box-body no-padding">

                    <table class="table table-hover">
                        <tr>
                            <td width="50" class="file_icon"><i class="fa fa-folder-o"></i></td>
                            <td>设计资料</td>
                            <td>2017-07-24</td>
                            <td width="100"></td>
                            <td width="150">
                                <div class="btn-group">
                                    <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                                        <i class="fa fa-ellipsis-h"></i>
                                    </button>
                                    <ul class="dropdown-menu">
                                        <li><a href="">打开</a></li>
                                        <li><a href="#">重命名</a></li>
                                        <li><a href="#">删除</a></li>
                                    </ul>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td width="50" class="file_icon"><i class="fa fa-file-o"></i></td>
                            <td>销售合同.doc</td>
                            <td>2017-07-24</td>
                            <td width="100">23kB</td>
                            <td width="100">
                                <div class="btn-group">
                                    <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                                        <i class="fa fa-ellipsis-h"></i>
                                    </button>
                                    <ul class="dropdown-menu">
                                        <li><a href="">下载</a></li>
                                        <li><a href="#">重命名</a></li>
                                        <li><a href="#">删除</a></li>
                                    </ul>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td width="50" class="file_icon"><i class="fa fa-folder-o"></i></td>
                            <td>样板间图片</td>
                            <td>2017-07-24</td>
                            <td width="100"></td>
                            <td width="100">
                                <div class="btn-group">
                                    <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                                        <i class="fa fa-ellipsis-h"></i>
                                    </button>
                                    <ul class="dropdown-menu">
                                        <li><a href="">打开</a></li>
                                        <li><a href="#">重命名</a></li>
                                        <li><a href="#">删除</a></li>
                                    </ul>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td width="50" class="file_icon"><i class="fa fa-file-o"></i></td>
                            <td>3月销售排名.xls</td>
                            <td>2017-07-24</td>
                            <td width="100">125kB</td>
                            <td width="100">
                                <div class="btn-group">
                                    <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                                        <i class="fa fa-ellipsis-h"></i>
                                    </button>
                                    <ul class="dropdown-menu">
                                        <li><a href="">下载</a></li>
                                        <li><a href="#">重命名</a></li>
                                        <li><a href="#">删除</a></li>
                                    </ul>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td width="50" class="file_icon"><i class="fa fa-file-o"></i></td>
                            <td>购房合同模板.doc</td>
                            <td>2017-07-24</td>
                            <td width="100">23kB</td>
                            <td width="100">
                                <div class="btn-group">
                                    <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                                        <i class="fa fa-ellipsis-h"></i>
                                    </button>
                                    <ul class="dropdown-menu">
                                        <li><a href="">下载</a></li>
                                        <li><a href="#">重命名</a></li>
                                        <li><a href="#">删除</a></li>
                                    </ul>
                                </div>
                            </td>
                        </tr>
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
 <script>
 	$(function(){
 		$("#addFolderBtn").click(function(){
 			layer.prompt({title:"请输入文件夹名称:"},function(text, index){
 				layer.close();
 				$.post("/disk/new/folder",{"pId":pid,"name":text,"accountId":accountId}).done(function(resp){
                    /* if(resp.state == 'success') {
                        layer.msg("创建成功");
                       
                        }
                    } else {
                        layer.msg(resp.message);
                    } */
                }).error(function(){
                    layer.msg("服务器异常");
                });
 			});
 		})
 	})
 
 </script>
</body>
</html>
