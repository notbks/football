<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE web-app PUBLIC "-//Sun Microsystems, Inc.//DTD Web Application 2.3//EN" "http://java.sun.com/dtd/web-app_2_3.dtd">
<html>
<head>
    <meta charset="UTF-8" http-equiv="content-type" content="text/html">
</head>
<body>
<!-- http://localhost:8080/football/ -->
	nihao &nbsp${p.name }
	<a href="<c:url value='/login.jsp'/>">注销&nbsp&nbsp</a>
	<a href="<c:url value='/toInfo'/>">修改个人信息</a>
</body>
</html>