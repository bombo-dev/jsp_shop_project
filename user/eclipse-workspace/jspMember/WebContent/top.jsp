<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- top.jsp -->
<html>
<head>
	<title>ȸ������</title>
</head>
<%
		boolean isLogin = false;
		String mbId = (String)session.getAttribute("mbId");
		if (mbId != null){
			isLogin = true;
		}
%>
<body>
	<div align="center">
		<table border="1" width="600" height="500">
			<tr height="10%">
				<th>
					<%if (isLogin){ %>
						<a href="logout.jsp">�α׾ƿ�</a>	
					<%}else{ %>
						<a href="login.jsp">�α���</a>
					<%}%>	
				</th>	
				<th><a href="memberSsn.jsp">ȸ������</a></th>
				<th><a href="memberAll.jsp">ȸ������</a></th>
				<th><a href="memberAll.jsp?mode=find">ȸ��ã��</a></th>
			</tr>
			<tr height="80%">
				<td width="100%" height="100%" colspan="4">