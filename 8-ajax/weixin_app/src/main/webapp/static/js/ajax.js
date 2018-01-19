// js模块化
// 该变量名必须唯一
var $ = (function(){
	function createXmlHttp(){
		// 创建xmlHttpRequest对象
		var xmlHttp = null;
		if(window.ActiveXObject) {
			// IE浏览器获得ajax引擎
			xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
		} else {
			// 非IE浏览器获得ajax引擎
			xmlHttp = new XMLHttpRequest();
		}
		return xmlHttp;
	}
	
	var ajax = {
		"createXmlHttp": createXmlHttp
	}
	
	return ajax;
})();