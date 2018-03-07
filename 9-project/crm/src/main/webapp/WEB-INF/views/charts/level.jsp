<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>凯盛软件CRM-客户级别统计</title>
    <%@ include file="../include/css.jsp"%>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<!-- Site wrapper -->
<div class="wrapper">
    <%@include file="../include/header.jsp"%>

    <jsp:include page="../include/sider.jsp">
        <jsp:param name="param" value="charts_level"/>
    </jsp:include>
    <!-- 右侧内容部分 -->
    <div class="content-wrapper">

        <!-- Main content -->
        <section class="content">

            <div class="box">
                <div class="box-header with-border">
                    <h3 class="box-title">客户级别数量统计</h3>
                </div>
                <div class="box-body">
                    <div id="bar" style="height: 300px;width: 100%"></div>
                </div>
            </div>
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->

    <%@ include file="../include/footer.jsp"%>

</div>
<!-- ./wrapper -->

<%@include file="../include/js.jsp"%>
<script src="/static/plugins/echarts/echarts.common.min.js"></script>
<script>
    $(function () {
        var bar = echarts.init(document.getElementById("bar"));

        var option = {
            title: {
                text: "客户级别数量统计",
                left: 'center'
            },
            tooltip: {},
            legend: {
                data: ['人数'],
                left: 'right'
            },
            xAxis: {
                type: 'category',
                data: []
            },
            yAxis: {},
            series: {
                name: "人数",
                type: 'bar',
                data:[]
            }
        }
        bar.setOption(option);


		$.get("/charts/level/count",function(json){
			if(json.state == 'success') {
				var nameArray = [];
				var dataArray = [];
				
				var array = json.data;
				for(var i = 0; i < array.length; i++) {
					var obj = array[i];
					nameArray.push(obj.level);
					dataArray.push(obj.count);
				}
				
				bar.setOption({
					xAxis: {
		                data: nameArray
		            },
		            series: {
		                data:dataArray
		            }
				})
				
			}
			
			
		});



    });
</script>

</body>
</html>
