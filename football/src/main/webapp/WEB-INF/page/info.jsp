<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" import="com.bks.pojo.Player"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人信息</title>
</head>
<body>
<jsp:include page="head.jsp"></jsp:include>

<form action="infoController" method="post">
	<table>
		<tr>
			<th>学号</th>
			<td><input type="text" name="sid" value="${p.sid }" readonly="readonly"><span>不可更改</span></td>
		</tr>
		<tr>
			<th>密码</th>
			<td><input type="password" name="password" value="${p.password }"></td>
		</tr>
		<tr>
			<th>姓名</th>
			<td><input type="text" name="name" value="${p.name }"></td>
		</tr>
		<tr>
			<th>专业</th>
			<td><input type="text" name="majors" value="${p.majors }"></td>
		</tr>
		<tr>
			<th>入队时间</th>
			<td><input type="text" name="joinYear" value="${p.joinYear }"></td>
		</tr>
		<tr>
			<th>球衣号码</th>
			<td><input type="text" name="number" value="${p.number }"></td>
		</tr>
		<tr>
			<th>位置</th>
			<td><input type="text" name="position" value="${p.position }"></td>
		</tr>
		<tr>
			<th>特长</th>
			<td><input type="text" name="specialty" value="${p.specialty }"></td>
		</tr>
		<tr>
			<th>队长？</th>
			<td><input type="text" name="isCaptain" value="${p.isCaptain }" readonly="readonly"><span>无更改权限</span></td>
		</tr>
		<tr>
			<th>经理？</th>
			<td><input type="text" name="isManager" value="${p.isManager }" readonly="readonly"><span>无更改权限</span></td>
		</tr>
		
	</table>
	<input type="submit" value="更改">
</form>
</body>
</html>