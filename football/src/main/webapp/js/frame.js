	if("${p.isCaptain}" =="是"){
		document.write("<link rel='stylesheet' type='text/css' href='<c:url value='/css/captain.css'/>' />");
	}else if("isManager" =="是"){
		document.write("<link rel='stylesheet' type='text/css' href='<c:url value='/css/manager.css'/>' />");
	}else{
		document.write("<link rel='stylesheet' type='text/css' href='<c:url value='/css/main.css'/>' />");
	}