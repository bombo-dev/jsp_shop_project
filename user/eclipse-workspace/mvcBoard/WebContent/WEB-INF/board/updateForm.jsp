<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" %>
<!-- updateForm.jsp -->
<html>
<head>	
	<title>�ۼ���</title>
	<script type="text/javascript">
		function check(){
			if (f.writer.value==""){
				alert("�̸��� �Է��� �ּ���!!")
				f.writer.focus()
				return false
			}
			if (f.subject.value==""){
				alert("������ �Է��� �ּ���!!")
				f.subject.focus()
				return false
			}
			if (f.content.value==""){
				alert("������ �Է��� �ּ���!!")
				f.content.focus()
				return false
			}
			if (f.passwd.value==""){
				alert("��й�ȣ�� �Է��� �ּ���!!")
				f.passwd.focus()
				return false
			}
			return true
		}
	</script>
</head>
<body>
	<div align="center">
		<form name="f" action="board_updatePro.board" 
		 	method="post" onsubmit="return check()">
		 	<input type="hidden" name="num" value="${getBoard.num}"/>	
			<table border="1" width="600">
				<tr bgcolor="yellow">
					<td colspan="2" align="center">�ۼ���</td>
				</tr>
				<tr>
					<th bgcolor="yellow" width="20%">�� ��</th>
					<td><input type="text" name="writer" value="${getBoard.writer}" readOnly></td>
				</tr>
				<tr>
					<th bgcolor="yellow">�� ��</th>
					<td><input type="text" name="subject" size="60" value="${getBoard.subject}"></td>
				</tr>
				<tr>
					<th bgcolor="yellow">Email</th>
					<td><input type="text" name="email" size="60" value="${getBoard.email}"></td>
				</tr>
				<tr>
					<th bgcolor="yellow">�� ��</th>
					<td><textarea name="content" rows="13" cols="60">${getBoard.content}</textarea></td>
				</tr>
				<tr>
					<th bgcolor="yellow">��й�ȣ</th>
					<td><input type="password" name="passwd"></td>
				</tr>
				<tr bgcolor="yellow">
					<td colspan="2" align="center">
						<input type="submit" value="�ۼ���">
						<input type="reset" value="�ٽ��ۼ�">
						<input type="button" value="��Ϻ���" 
						onclick="window.location='board_list.board'">
					</td>
				</tr>
			</table>
			
		</form>
	</div>
</body>
</html>