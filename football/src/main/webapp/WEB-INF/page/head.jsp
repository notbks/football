<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE web-app PUBLIC "-//Sun Microsystems, Inc.//DTD Web Application 2.3//EN" "http://java.sun.com/dtd/web-app_2_3.dtd">
<html>
<head>
    <meta charset="UTF-8" http-equiv="content-type" content="text/html">
</head>
<body>
	nihao &nbsp
	<a href="<c:url value='/login.jsp'/>">注销</a>
	<form action="infoController" method="post">
		<input type="button" value="修改个人信息">
	</form>
</body>
</html>