<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- writeForm.jsp -->
<html>
<head>	
	<title>�۾���</title>
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
		<form name="f" action="notice_board_write.do" method="post" onsubmit="return check()">
			<table border="1" width="600">
				<tr bgcolor="yellow">
					<td colspan="2" align="center">�۾���</td>
				</tr>
				<tr>
					<th bgcolor="yellow" width="20%">�� ��</th>
					<td><input type="text" name="writer"></td>
				</tr>
				<tr>
					<th bgcolor="yellow">�� ��</th>
					<td><input type="text" name="subject" size="60"></td>
				</tr>
				<tr>
					<th bgcolor="yellow">Email</th>
					<td><input type="text" name="email" size="60"></td>
				</tr>
				<tr>
					<th bgcolor="yellow">�� ��</th>
					<td><textarea name="content" rows="13" cols="60"></textarea></td>
				</tr>
				<tr>
					<th bgcolor="yellow">��й�ȣ</th>
					<td><input type="password" name="passwd"></td>
				</tr>
				<tr bgcolor="yellow">
					<td colspan="2" align="center">
						<input type="submit" value="�۾���">
						<input type="reset" value="�ٽ��ۼ�">
						<input type="button" value="��Ϻ���" 
						onclick="window.location='notice_board.do'">
					</td>
				</tr>
			</table>
			
		</form>
	</div>
</body>
</html>




