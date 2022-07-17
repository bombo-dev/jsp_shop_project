<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="board.*"%>
<!-- updateForm.jsp -->
<jsp:useBean id="bdao" class="board.BoardDAO" />
<%
	String num = request.getParameter("num");
	if (num == null || num.trim().equals("")){
		response.sendRedirect("index.jsp");
		return;
	}
	
	BoardDTO dto = bdao.getBoard(Integer.parseInt(num), "update"); 
%>
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
		<form name="f" action="updatePro.jsp" 
		 	method="post" onsubmit="return check()">
		 	<input type="hidden" name="num" value="<%=dto.getNum()%>"/>	
			<table border="1" width="600">
				<tr bgcolor="yellow">
					<td colspan="2" align="center">�ۼ���</td>
				</tr>
				<tr>
					<th bgcolor="yellow" width="20%">�� ��</th>
					<td><input type="text" name="writer" value="<%=dto.getWriter()%>" readOnly></td>
				</tr>
				<tr>
					<th bgcolor="yellow">�� ��</th>
					<td><input type="text" name="subject" size="60" value="<%=dto.getSubject()%>"></td>
				</tr>
				<tr>
					<th bgcolor="yellow">Email</th>
					<td><input type="text" name="email" size="60" value="<%=dto.getEmail()%>"></td>
				</tr>
				<tr>
					<th bgcolor="yellow">�� ��</th>
					<td><textarea name="content" rows="13" cols="60"><%=dto.getContent()%></textarea></td>
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
						onclick="window.location='list.jsp'">
					</td>
				</tr>
			</table>
			
		</form>
	</div>
</body>
</html>