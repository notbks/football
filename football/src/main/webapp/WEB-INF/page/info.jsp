<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人信息</title>
</head>
<body>
<jsp:include page="head.jsp"></jsp:include>
<form action="/infoController" method="post">
	<table>
		<tr>
			<td>密码</td>
			<td><input type="password" name="password"></td>
		</tr>
		<tr>
			<td>姓名</td>
			<td><input type="text" name="name"></td>
		</tr>
		<tr>
			<td>专业</td>
			<td><input type="text" name="majors"></td>
		</tr>
		<tr>
			<td>入队年份</td>
			<td><input type="text" name="joinYear"></td>
		</tr>
		<tr>
			<td>球衣号码</td>
			<td><input type="text" name="number"></td>
		</tr>
		<tr>
			<td>位置</td>
			<td><input type="text" name="positon"></td>
		</tr>
		<tr>
			<td>特长</td>
			<td><input type="text" name="specialty"></td>
		</tr>
	</table>
	<input type="submit" value="更改">
</form>
</body>
</html>