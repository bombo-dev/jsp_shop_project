<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- content.jsp -->
<html>
<head>
	<title>�۳��뺸��</title>
</head>
<body>
	<div align="center">
		<b>�۳��� ����</b>
		<table border="1" width="600">
			<tr>
				<th width="20%" bgcolor="yellow">�۹�ȣ</th>
				<td align="center" width="30%">${getBoard.num}</td>
				<th width="20%" bgcolor="yellow">��ȸ��</th>
				<td align="center" width="30%">${getBoard.readcount}</td>
			</tr>
			<tr>
				<th width="20%" bgcolor="yellow">�ۼ���</th>
				<td align="center" width="30%">${getBoard.writer}</td>
				<th width="20%" bgcolor="yellow">�ۼ���</th>
				<td align="center" width="30%">${getBoard.reg_date}</td>
			</tr>
			<tr>
				<th width="20%" bgcolor="yellow">������</th>
				<td align="center" width="80%" colspan="3">
					${getBoard.subject}
				</td>
			</tr>
			<tr>
				<th width="20%" bgcolor="yellow">�۳���</th>
				<td width="80%" colspan="3">
					${getBoard.content}
				</td>
			</tr>
			<tr bgcolor="yellow">
				<td align="right" colspan="4">
					<input type="button" value="�ۼ���"
onclick="window.location='board_updateForm.board?num=${getBoard.num}'">
					<input type="button" value="�ۻ���"
onclick="window.location='board_deleteForm.board?num=${getBoard.num}'">
					<input type="button" value="�۸��" 
						onclick="window.location='board_list.board'">
				</td>		
			</tr>
		</table>	
	</div>
</body>
</html>








