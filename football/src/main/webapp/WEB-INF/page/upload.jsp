<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
<br/>
${param.message}
<br/>
<form action="uploadFile" method="post" enctype="multipart/form-data">
	选择文件：<input type="file" name="file">
	<input type="submit" value="上传">
</form>
<br/>
<br/>
</body>
</html>