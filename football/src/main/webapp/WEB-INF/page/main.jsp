<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页</title>
</head>
<body>
<jsp:include page="head.jsp" flush="true"></jsp:include>
<a href="<c:url value='/showAllPlayersController'/>">showAllPlayers</a>

<jsp:include page="players.jsp" flush="true"></jsp:include>
<jsp:include page="match.jsp" flush="true"></jsp:include>
</body>
</html>