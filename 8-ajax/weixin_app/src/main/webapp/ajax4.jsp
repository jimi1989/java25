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
		<tbody>
			
		</tbody>
	</table>
	
    <script src="/static/js/ajax.js"></script>
    <script>
    	(function(){
			var btn = document.getElementById("btn");   		
    		
    		var xmlHttp = $.createXmlHttp();
    		btn.onclick = function(){
    			xmlHttp.open("get","/user.xml");
    			xmlHttp.onreadystatechange = function(){
    				if(xmlHttp.readyState == 4) {
    					if(xmlHttp.status == 200) {
    						// 获得xml文档对象,并解析
    						var xmlDoc = xmlHttp.responseXML;
    						var userTags = xmlDoc.getElementsByTagName("user");
    						for(var i = 0; i < userTags.length; i++) {
    							var userTag = userTags[i];
    							var id = userTag.getAttribute("id");
    							var name = userTag.getElementsByTagName("name")[0].childNodes[0].nodeValue;
    							var age = userTag.getElementsByTagName("age")[0].childNodes[0].nodeValue;
    							//console.log("id:" + id + ",name:" + name +",age:" + age);
    							
    							// 创建tr标签
    							var tr = document.createElement("tr"); // <tr></tr>
    							// 创建3个td标签
    							var idTd = document.createElement("td");  // <td></td>
    							var nameTd = document.createElement("td"); // <td></td>
    							var ageTd = document.createElement("td"); // <td></td>
    							
    							// 创建文本子节点
    							var idNode = document.createTextNode(id); // 1
    							var nameNode = document.createTextNode(name); // jack
    							var ageNode = document.createTextNode(age); //23
    							
    							var tbody = document.getElementsByTagName("tbody")[0];
    							
    							// 拼装td tr  tbody
    							idTd.appendChild(idNode); // <td>1</td>
    							nameTd.appendChild(nameNode); // <td>jack</td>
    							ageTd.appendChild(ageNode); // <td>23</td>
    							
    							tr.appendChild(idTd);
    							tr.appendChild(nameTd);
    							tr.appendChild(ageTd);  // <tr>	<td>1</td>	<td>jack</td> <td>23</td> </tr>
    							
    							tbody.appendChild(tr);
    						}
    						
    					} else {
    						alert("服务器开小差了...")
    					}
    				}
    			}
    			xmlHttp.send();
    		}
    		
    		
    	})();
    </script>
</body>
</html>