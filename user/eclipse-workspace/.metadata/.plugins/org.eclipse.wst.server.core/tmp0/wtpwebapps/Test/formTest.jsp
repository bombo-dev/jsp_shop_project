<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- formTest.jsp -->
<html>
<head>
	<title>form</title>
</head>
<body>
	<form name="f" action="result.jsp" method="post">
		하고싶은 말 : 
		<textarea name="content"></textarea><br>
		<input type="submit" value="전송">
		<!-- 아이디 : <input type="text" name="id"><br>
		비밀번호 : <input type="password" name="pwd"><br>
		<input type="submit" value="로그인">
		<input type="reset" value="다시입력"> -->
	</form>
</body>
</html>