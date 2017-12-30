<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>高自由度搜索</title>
<script type="text/javascript" src="/football/js/jquery.min.js"></script>
<script type="text/javascript">
	function submit(){
		var name =$("#name").val();
		var age =$("#age").val();
		
		$.ajax({
			url:"/football/jsonTest",
			data:{"name":name, "age":age},
			success:function(result){
				$("#checkResult").html(result);
			}
		});
	}
</script>
</head>
<body>
	<span id="checkResult"></span>
	<table>
		<tr>
			<th><input type="text" id=name>name</th>
			<th><input type="text" id=age>age</th>
			<th><input type="submit" id=submit onclick="submit();">submit</th>
		</tr>
	</table>
</body>
</html>