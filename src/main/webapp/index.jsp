<%@ page contentType="text/html; charset=UTF-8" language="java" import="java.util.*" %>  
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<body>
<h2>Hello World!!!</h2>
<a href="<%=basePath%>api/model">click me</a>
</body>
</html>
