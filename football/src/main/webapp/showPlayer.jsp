<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<html>
<head>
<title>ssss</title>
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
<h3>下面是王豪杰的数据</h3>
${player.name}<br/>
${player.sid}


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