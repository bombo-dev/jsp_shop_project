<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- fileUpload.jsp -->
<html>
<head>
	<title>���Ͼ��ε��׽�Ʈ</title>
</head>
<body>
	<form name="f" action="fileUpload_ok.do" method="post"
							enctype="multipart/form-data">
		<table border="1">
			<tr>
				<th>�̸�</th>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<th>���ϸ�</th>
				<td><input type="file" name="filename"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="����">
				</td>
			</tr>
		</table>					
	</form>
</body>
</html>