<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- depart_choice.jsp -->
<html>
<head>
	<title>�а�����</title>
</head>
<body>
	<h1 align="center">�а� ���� ������</h1>
	<form name="f" action="depart.do" method="post">
		�а����� : 
		<select name="depart" size="1">
			<option value="c">C</option>
			<option value="java">JAVA</option>
			<option value="python">���̽�</option>
			<option value="go">GO</option>
		</select>
		<input type="submit" value="����">
	</form>
</body>
</html>