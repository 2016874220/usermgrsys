<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!-- 在此JSP页面中使用如下命令来声明使用标签库（aa的uri有两种："http://lingnan.edu.cn"以及"/mytagstest"） -->
<%@ taglib prefix="aa" uri="/mytagstest" %>
<%@ taglib prefix="c" uri="/jstlc" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<aa:hello/>
	<br>
	
	<c:set var="a" value="aaa"/>
	<c:out value="a"/>
	

</body>
</html>