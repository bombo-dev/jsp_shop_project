<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- member_input.jsp -->
<%@ include file="top.jsp"%>
<%
	request.setCharacterEncoding("EUC-KR");
	String name = request.getParameter("name");
	String ssn1 = request.getParameter("ssn1");
	String ssn2 = request.getParameter("ssn2");
	if (name==null || ssn1==null || ssn2==null || 
		name.trim().equals("") || ssn1.trim().equals("") || ssn2.trim().equals("")){
		response.sendRedirect("index.jsp");
		return;
	}
%>
<script type="text/javascript">
	function check(){
		if (f.id.value==""){
			alert("���̵� �Է��� �ּ���!!")
			f.id.focus()
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
<div align="center">
	<form name="f" action="member_input_ok.jsp" 
			method="post" onsubmit="return check()">
			
		<table border="1" width="80%">
			<tr>
				<th width="20%" bgcolor="yellow">�̸�</th>
				<td><input type="text" name="name" value="<%=name%>" readOnly></td>
			</tr>
			<tr>
				<th bgcolor="yellow">���̵�</th>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<th bgcolor="yellow">��й�ȣ</th>
				<td><input type="password" name="passwd"></td>
			</tr>
			<tr>
				<th bgcolor="yellow">�ֹι�ȣ</th>
				<td><input type="text" name="ssn1" value="<%=ssn1%>" readOnly>
					- <input type="password" name="ssn2" value="<%=ssn2%>" readOnly></td>
			</tr>
			<tr>
				<th bgcolor="yellow">�̸���</th>
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<th bgcolor="yellow">��ȭ��ȣ</th>
				<td><input type="text" name="hp1" size="3" maxlength="3">
					-<input type="text" name="hp2" size="4" maxlength="4">
					-<input type="text" name="hp3" size="4" maxlength="4"></td>
			</tr>
			<tr>
				<td align="center" colspan="2" bgcolor="yellow">
					<input type="submit" value="ȸ������">
					<input type="reset" value="�ٽ��Է�">
				</td>
			</tr>
		</table>
	</form>
</div>
<%@ include file="bottom.jsp"%>