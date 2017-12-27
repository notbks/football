<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆</title>

<script type="text/javascript" src="<c:url value='/js/jquery.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/jquery.cookie.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/jquery.base64.js'/>"></script>
<script type="text/javascript">
	//设置cookie  
	function setCookie(){ 
	    var sid = $("#sid").val(); //获取用户名信息  
	    var pwd = $("#password").val(); //获取登陆密码信息  
	    var checked = $("#checkbox").prop("checked");//获取“是否记住密码”复选框
	    
	    if(checked == true){ //判断是否选中了“记住密码”复选框  
	       $.cookie("sid",sid);//调用jquery.cookie.js中的方法设置cookie中的用户名  
	       $.cookie("pwd",$.base64.encode(pwd));//调用jquery.cookie.js中的方法设置cookie中的登陆密码，并使用base64（jquery.base64.js）进行加密  
	    }else{
	    	//加了下面这句，密码就无法解密，不知道为什么
	       //$.cookie("sid",sid);	
	       $.cookie("pwd", null);   
	    }
	}   
	
	//获取cookie 
	function getCookie(){  
	    var sid = $.cookie("sid"); //获取cookie中的用户名  
	    var pwd = $.cookie("pwd"); //获取cookie中的登陆密码  
	    if(pwd!=null){	//密码存在的话把“记住用户名和密码”复选框勾选住  
	       $("#checkbox").attr("checked","true");  
	    }  
	    if(sid){//用户名存在的话把用户名填充到用户名文本框  
	       $("#sid").val(sid);  
	    }  
	    if(pwd!=null){//密码存在的话把密码填充到密码文本框  
	       $("#password").val($.base64.decode(pwd)); 
	    }  
	}
		
</script>

</head>
<body onload="getCookie();">
<form action="loginController" method="post">
	<table>
		<tr>
			<th>学号</th>
			<td><input type="text" id="sid" name="sid" value="${param.sid}"><span>${param.message}</span></td>
		</tr>
		<tr>
			<th>密码</th>
			<td><input type="password" id="password" name="password"></td>
		</tr>
	</table>
	<input type="checkbox" id="checkbox" name="checkbox" onclick="setCookie();">记住我<br/>
	<input type="submit" value="登陆">

</form>
<a href="<c:url value='/regist.jsp'/>">还没账号？点击注册</a><br/>

</body>
</html>