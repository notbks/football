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
<hr/>

<button onclick="showDiv1();">球员页</button>
<div id="div1" style="display:block">
	<a href="<c:url value='/showAllPlayersController'/>">showAllPlayers</a>
	<jsp:include page="players.jsp" flush="true"></jsp:include>
</div>
<script type="text/javascript">
	function showDiv1(){
		var div1 =document.getElementById("div1");
		if (div1.style.display=="none"){
			div1.style.display="block";
		}else{
			div1.style.display="none";
		}
	}
</script>
<hr/>

<jsp:include page="match.jsp" flush="true"></jsp:include>
<hr/>

<jsp:include page="showFile.jsp"></jsp:include>

</body>
</html>