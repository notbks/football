<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE web-app PUBLIC "-//Sun Microsystems, Inc.//DTD Web Application 2.3//EN" "http://java.sun.com/dtd/web-app_2_3.dtd">
<html>
<head>
    <meta charset="UTF-8" http-equiv="content-type" content="text/html">
</head>
<body>

	nihao &nbsp${p.name }

	<a href="<c:url value='/logout'/>">注销</a>
	<a href="<c:url value='/toInfo'/>">修改个人信息</a>
	<a href="<c:url value='/toSearch'/>">搜索全部</a>
	
	<c:if test="${p.isCaptain =='是' || p.isManager =='是'}">
		<a href="<c:url value='/toAddMatch'/>">添加比赛信息</a>
		<a href="<c:url value='/toAddAnnouncement'/>">发布公告</a>
		<a href="<c:url value='/toTransition'/>">换届</a>
	</c:if>
	<br/>
	<hr/>
	${date}
</body>
</html>