<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h2>Hello World!</h2>
<h3>欢迎登陆哦~~~~~~~~~~~</h3>
<a href="<c:url value='/showPlayer.jsp'/>">查看sid是030313的运动员</a><br/>

<form action="findPlayer" method="post">
	<input type="text" name="sid">
	<input type="submit" value="提交">
</form>

</body>
</html>