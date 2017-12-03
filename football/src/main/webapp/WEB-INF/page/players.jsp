<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>

<table>
	<tr>
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
			<td>${one.name}</td>
			<td>${one.joinYear}</td>
			<td>${one.number}</td>
			<td>${one.position}</td>
			<td>${one.specialty}</td>
			<td>${one.isCaptain}</td>
			<td>${one.isManager}</td>
		</tr>
	</c:forEach>
</table>
<div>
	<a href="?start=0">首	页</a>
	
	<c:if test="${playerpage.start !=0}">
		<a id="shang" href="?start=${playerpage.start-playerpage.count}">上一页</a>
	</c:if>
	
	<span>当前页</span>
	<span id="xz">${(playerpage.start/5)+1}</span>
	
	<c:if test="${playerpage.start !=playerpage.last}">
		<a id="xia" href="?start=${playerpage.start+playerpage.count}">下一页</a>
	</c:if>
	
	<a href="?start=${playerpage.last}">尾	页</a>
	
	<span>共</span>
	<span>${(playerpage.last/5)+1}</span>
	<span>页</span>
</div>

</body>
</html>