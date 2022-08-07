<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- fileUpload.jsp -->
<html>
<head>
	<title>파일업로드테스트</title>
</head>
<body>
	<form name="f" action="fileUpload_ok.do" method="post"
							enctype="multipart/form-data">
		<table border="1">
			<tr>
				<th>이름</th>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<th>파일명</th>
				<td><input type="file" name="filename"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="전송">
				</td>
			</tr>
		</table>					
	</form>
</body>
</html>