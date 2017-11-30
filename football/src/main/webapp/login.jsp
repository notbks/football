<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆</title>
</head>
<body>
<form action="loginController" method="post">
	<table>
		<tr>
			<td>学号</td>
			<td><input type="text" name="sid"></td>
		</tr>
		<tr>
			<td>密码</td>
			<td><input type="password" name="password"></td>
		</tr>
		<tr>
			<td>姓名</td>
			<td><input type="password" name="name"></td>
		</tr>
	</table>
	<input type="submit" value="登陆">
	
</form>
<a href="<c:url value='/regist.jsp'/>">还没账号？点击注册</a>
<span>${message}</span>
</body>
</html>