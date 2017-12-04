<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页</title>
<style type="text/css">
	div{
		color:red;
	}
	input{
		width:500px;
		height:100px;
	}
</style>

<script type="text/javascript">
	if("${p.isCaptain}" =="是"){
		document.write("<link rel='stylesheet' type='text/css' href='<c:url value='/css/captain.css'/>' />");
	}else if("isManager" =="是"){
		document.write("<link rel='stylesheet' type='text/css' href='<c:url value='/css/manager.css'/>' />");
	}else{
		document.write("<link rel='stylesheet' type='text/css' href='<c:url value='/css/main.css'/>' />");
	}
</script>
</head>

<body>

<div>嘿嘿嘿</div>
<jsp:include page="head.jsp" flush="true"></jsp:include>
<hr/>

<div id="buttons" align="center">
	<input type="button" onclick="window.open('<c:url value='/showAllPlayersController'/>')" value="球员页"><br/>
	<input type="button" onclick="window.open('<c:url value='/showFiles'/>')" value="所有文件"><br/>
	<input type="button" onclick="window.open('<c:url value='/toMatch'/>')" value="球赛信息">
</div>

</body>
</html>