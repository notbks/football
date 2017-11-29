<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎注册</title>
</head>
<body>
<form action="/loginController" method="post">
用户名：<input type="text" name="name">
密	码：<input type="password" name="password">
手机号：<input type="text" name="phone">
性	别：<input type="radio" name="sex" value="nv">女
		<input type="radio" name="sex" value="nan">男
生	日：<select>
			<option value="0">请选择</option>
			<option value="1995">1995</option>
			<option value="1996">1996</option>
			<option value="1997">1997</option>
		</select>
注册原因：<input type="checkbox" name="why" value="w1">朋友推荐
		 <input type="checkbox" name="why" value="w2">广告
		 <input type="checkbox" name="why" value="w3">网络知名度
		 
验证码：

</form>
</body>
</html>