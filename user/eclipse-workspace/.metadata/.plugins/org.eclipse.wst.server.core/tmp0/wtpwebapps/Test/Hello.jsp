<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- Hello.jsp -->
<html>
<head>
	<title>hello</title>
</head>
<body>
	<h1>Hello, JSP!!</h1>
	<%	for (int i=1; i<=10; ++i){ %>
		<h3>Hello, JSP<%=i%>!!</h3>
	<%	} %>
</body>
</html>