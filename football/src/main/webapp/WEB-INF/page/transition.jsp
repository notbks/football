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
<form action="transition" method="post">
	<table>
		<tr>
		<th>ssss</th>
			<th>姓名</th>
			<th>学号</th>
			<th>密码</th>
			<th>专业</th>
			<th>入队时间</th>
			<th>球衣号码</th>
			<th>场上位置</th>
			<th>特点</th>
			<th>队长</th>
			<th>经理</th>
		</tr>
		<c:forEach items="${allPlayers }" var="one" varStatus="st">
			<tr>
			<td>${st.count-1}</td>
				<td><input type="text" name="PlayersList[${st.count-1}].name" value="${one.name}" readonly="readonly"></td>
				<td><input type="hidden" name="PlayersList[${st.count-1}].sid" value="${one.sid}" readonly="readonly"></td>
				<td><input type="hidden" name="PlayersList[${st.count-1}].password" value="${one.password}" readonly="readonly"></td>
				<td><input type="hidden" name="PlayersList[${st.count-1}].majors" value="${one.majors}" readonly="readonly"></td>
				<td><input type="text" name="PlayersList[${st.count-1}].joinYear" value="${one.joinYear}" readonly="readonly"></td>
				<td><input type="text" name="PlayersList[${st.count-1}].number" value="${one.number}" readonly="readonly"></td>
				<td><input type="text" name="PlayersList[${st.count-1}].position" value="${one.position}" readonly="readonly"></td>
				<td><input type="text" name="PlayersList[${st.count-1}].specialty" value="${one.specialty}" readonly="readonly"></td>
				<td><input type="text" name="PlayersList[${st.count-1}].isCaptain" value="${one.isCaptain}"></td>
				<td><input type="text" name="PlayersList[${st.count-1}].isManager" value="${one.isManager}"></td>
			</tr>
		</c:forEach>
	</table>
	<input type="submit" value="确定">
</form>

</body>
</html>