<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>所有文件</title>
</head>
<body>

<table>
	<tr>
		<th>编号</th>
		<th>文件名</th>
		<th>上传日期</th>
	</tr>
	<c:forEach items="${files}" var="file" varStatus="index">
		<tr>
			<td>${file.fid}</td>
			<td><a href="<c:url value='/DownloadServlet?fid=${file.fid}'/>">${file.fname}</a></td>
			<td>${file.fdate}</td>
		</tr>
	</c:forEach>
</table>

<jsp:include page="upload.jsp"></jsp:include>

</body>
</html>