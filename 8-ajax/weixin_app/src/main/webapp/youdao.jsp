<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>我的翻译官	</title>
</head>
<body>
	<input type="text" id="word" />
	<button id="btn">翻译</button>
	<div id="content"></div>
	
	<script src="/static/js/ajax.js"></script>
	<script>
		(function(){
			var input = document.getElementById("word");
			var btn = document.getElementById("btn");
			var content = document.getElementById("content");
			
			btn.onclick = function(){
				content.innerText = "";
				var xmlHttp = $.createXmlHttp();
				xmlHttp.open("GET","/youdao2?p=" + input.value);
		 		xmlHttp.onreadystatechange = function(){
					if(xmlHttp.readyState == 4) {
						if(xmlHttp.status == 200) {
							/* var xmlDom = xmlHttp.responseXML;
							var explains = xmlDom.getElementsByTagName("explains")[0];
							var ex = explains.getElementsByTagName("ex")[0];
							var text = ex.childNodes[0].nodeValue;
							 */
							 
							var json = JSON.parse(xmlHttp.responseText);
							console.log(json);
							var text = json.translation[0];
							var p = document.createElement("p");// <p></p>
							var textNode = document.createTextNode(text);
							
							p.appendChild(textNode);
							content.appendChild(p);
							
						} else {
							alert("系统繁忙，请稍后重试");
						}
					}
					
				}
				xmlHttp.send();
			}
			
		})();
	
	
	</script>
</body>
</html>