<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎注册</title>
</head>
<body>
<script type="text/javascript">

	//在网页加载完后运行这个方法,防止元素读取不到
	window.onload =function(){
		//根据name获取对象text
		var sidText =document.getElementsByName("sid")[0];
		//监听sidText 当它失去焦点是执行
		sidText.onblur =function(){
			//1：得到异步对象
			var xmlHttp =new XMLHttpRequest();
			//2：打开连接  中间是请求地址
			xmlHttp.open("POST", "<c:url value='checkSid'/>", true);
			//3：设置请求头
			xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
			//4：发送请求，给出请求体
			xmlHttp.send("sid=" + sidText.value);
			//5：给xmlhttp的onreadystatechange事件 注册监听
			xmlHttp.onreadystatechange =function(){
				//0刚创建，还没调用open()方法
				//1：调用完open方法 还没调用send()方法
				//2：调用完send()方法
				//3：服务器开始响应 但不代表响应结束
				//4：服务器相应结束
				if(xmlHttp.readyState ==4 && xmlHttp.status ==200){//双重判断，服务器相应正常200结束4
					//获取返回的值
					var text =xmlHttp.responseText;
					//获取span对象
					var span =document.getElementById("sidspan");
					if(text =="1"){
						span.innerHTML ="已被注册";
					}else{
						span.innerHTML ="可以注册";
					}
				}
			};
		};
	};
</script>
<script type="text/javascript">
	window.onload =function(){
		var name =document.getElementsByName("name")[0];
		var sub =document.getElementById("sub");
		
		name.onblur =function(){
			if(name.value ==""){
				sub.style.display ="none";
			}else{
				sub.style.display ="block";
			}
		};	
	};
</script>
<form action="registController" method="post">
	<table>
		<tr>
			<td>学号</td>
			<td><input type="text" name="sid"><span id="sidspan"></span></td>
		</tr>
		<tr>
			<td>密码</td>
			<td><input type="password" name="password" value=""></td>
		</tr>
		<tr>
			<td>姓名</td>
			<td><input type="text" name="name" value="无名氏"></td>
		</tr>
		<tr>
			<td>专业</td>
			<td><input type="text" name="majors" value="0"></td>
		</tr>
		<tr>
			<td>入队年份</td>
			<td><input type="text" name="joinYear" value="1949"></td>
		</tr>
		<tr>
			<td>球衣号码</td>
			<td><input type="text" name="number" value="0"></td>
		</tr>
		<tr>
			<td>位置</td>
			<td><input type="text" name="positon" value="没机会上场"></td>
		</tr>
		<tr>
			<td>特长</td>
			<td><input type="text" name="specialty" value="懒得写"></td>
		</tr>
		<tr>
			<td>队长？</td>
			<td><input type="text" name="isCaptain" value="否">队长</td>
		</tr>
		<tr>
			<td>经理？</td>
			<td><input type="text" name="isManager" value="否">经理</td>
		</tr>
	</table>
	<input type="submit" id="sub" style="display:block" value="注册">
</form>
</body>
</html>