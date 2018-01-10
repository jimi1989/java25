<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <link rel="stylesheet" href="/static/css/bootstrap.css" />
</head>
<body>
    <div class="container">
   	<%
   		pageContext.setAttribute("age", 12); // 当前页面
    %>
    
    <h4>${message}</h4>
    <h4><c:out value="${message}" escapeXml="true" default="登录ok"></c:out></h4>
    
    <h4>${fn:startsWith(name,"ja")}</h4>
    <h4>${fn:replace(name,"to","mo")}</h4>
    
    <h4>我今年${pageScope.age}岁了</h4>
    <h4>我的名字是:${name},${requestScope.address} </h4>
    <h4>${sessionScope.address }</h4>
    <h4>${applicationScope.status}</h4>
    
    <h4>
    	管理员帐号：${admin.name} <br />
    	管理员密码：${admin.password} <br />
    	管理员信息： ${admin.info}
    </h4>
    
    <h4>${12 + 15 }</h4>
    <h4>${"15" == "15" }</h4>
    <h4>${not empty lists}</h4>
    
   <%--  <c:if test="${requestScope.name == 'jack'}">
    	<h4>hello,jack</h4>
    </c:if>
    --%>
   
   <c:choose>
   		<c:when test="${requestScope.name == 'jack' }">
   			<h4>hello,jack</h4>
   		</c:when>
   		<c:when test="${requestScope.name == 'tom' }">
   			<h4>hello,tom</h4>
   		</c:when>
   		<c:otherwise>
   			<h4>hello,other</h4>
   		</c:otherwise>
   </c:choose>
   
   <c:forEach items="${lists}" var="n" varStatus="vs" begin="0" end="3" step="2">
   		<h4>${vs.index}-->${vs.count}-->${vs.first}-->${vs.last}-->${n}</h4>
   </c:forEach>
   
    
    </div>
    
</body>
</html>