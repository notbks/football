<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>高自由度搜索</title>
	<script type="text/javascript" src="/football/js/jquery.min.js"></script>
	<script type="text/javascript">
		$(function(){
			//针对不同的要求，展示不同的筛选条件
			var pd =$("#playerDiv");
			var md =$("#matchDiv");
			
			$("#who").change(function(){
				if($("#who").val() == "player"){	//判断是哪种要求，然后只展示需要的div块
					pd.show();
					md.hide();
				}else if($("#who").val() =="match"){
					pd.hide();
					md.show();
				}
			});
		});
	</script>
	<script type="text/javascript">
		function search(){
			//异步处理搜索请求		
			$.ajax({
				url:"/football/search",
				data:$("#searchForm").serialize(),		//表单的serialize()方法，把提交的数据序列化成字符串，像json
				success:function(result){
					var resultList =result.split(",,,,");	//把结果分割为多个字符串， 分隔符为,,,,
					for(var i=0; i<resultList.length; i++){	
						var new_tr =$("<p></p>").text(resultList[i]);	//添加子节点，三种方法
						$("#show").append(new_tr);
					}
				}
			});
		}
	</script>
</head>

<body>
	<span>请选择要搜索的类型：</span>
	<select id="who" name="who">
		<option value="player">球员</option>
		<option value="match">比赛</option>
	</select>
	
	<form action="/football/search" method="post" id="searchForm">
		<div id="playerDiv">
			<table>
				<tr>
					<th>学号</th>
					<td><input id="sid" name="sid" type="text"></td>
					<th>姓名</th>
					<td><input id="name" name="name" type="text"></td>
				</tr>
				<tr>
					<th>号码</th>
					<td><input id="number" name="number" type="text"></td>
					<th>位置</th>
					<td><input id="position" name="position" type="text"></td>
				</tr>
				<tr>
					<th>队长</th>
					<td><input id="isCaptain" name="isCaptain" type="text"></td>
					<th>经理</th>
					<td><input id="isManager" name="isManager" type="text"></td>
				</tr>
			</table>
		</div>
	
		<div id="matchDiv">
			<table>
				<tr>
					<th>时间</th>
					<td><input id="date" type="text"></td>
					<th>比赛性质</th>
					<td><input id="serie" type="text"></td>
				</tr>
				<tr>
					<th>主队</th>
					<td><input id="home" type="text"></td>
					<th>客队</th>
					<td><input id="visiting" type="text"></td>
				</tr>
			</table>
		</div>
	</form>
	
	<button onclick="search();">搜索</button>
	
	<div id="show"></div>
</body>
</html>