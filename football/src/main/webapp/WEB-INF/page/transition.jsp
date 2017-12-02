<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>再见，队长！</title>
</head>
<body>
<a href="<c:url value='/getAllPlayersForTransition'/>">查看所有球员</a>

<table>
	<tr>
	<th>--</th>
		<th>姓名</th>
		<th>入队时间</th>
		<th>球衣号码</th>
		<th>场上位置</th>
		<th>特点</th>
		<th>队长</th>
		<th>经理</th>
	</tr>
	<c:forEach items="${allPlayers }" var="one" varStatus="st">
		<tr>
		<td>${st.count}</td>
			<td>${one.name}"</td>
			<td>${one.joinYear}</td>
			<td>${one.number}</td>
			<td>${one.position}</td>
			<td>${one.specialty}</td>
			<td>
				<form action="transitionCaptain" method="post">
					<input type="text" name="isCaptain" value="${one.isCaptain}">
					<input type="hidden" name="sid" value="${one.sid}">
					<input type="submit" value="更改">
				</form>
			</td>
			<td>
				<form action="transitionManager" method="post">
					<input type="text" name="isManager" value="${one.isManager}">
					<input type="hidden" name="sid" value="${one.sid}">
					<input type="submit" value="更改">
				</form>
			</td>
		</tr>
	</c:forEach>
</table>

</body>
</html>