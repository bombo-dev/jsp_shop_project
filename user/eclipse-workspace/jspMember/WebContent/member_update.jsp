<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="member.*"%>
<!-- member_update.jsp -->
<jsp:useBean id="mbdao" class="member.MemberDAO" />
<%
	String no = request.getParameter("no");
	if (no==null || no.trim().equals("")){
		response.sendRedirect("index.jsp");
		return;
	}
	
	MemberDTO dto = mbdao.getMember(Integer.parseInt(no));
%>
<%@ include file="top.jsp"%>
<script type="text/javascript">
	function check(){
		if (f.passwd.value==""){
			alert("��й�ȣ�� �Է��� �ּ���!!")
			f.passwd.focus()
			return false
		}
		return true
	}
</script>
<div align="center">
	<form name="f" action="member_update_ok.jsp" 
			method="post" onsubmit="return check()">
		<input type="hidden" name="no" value="<%=dto.getNo()%>"/>	
		<table border="1" width="80%">
			<tr>
				<th width="20%" bgcolor="yellow">�̸�</th>
				<td><input type="text" name="name" value="<%=dto.getName()%>" readOnly></td>
			</tr>
			<tr>
				<th bgcolor="yellow">���̵�</th>
				<td><input type="text" name="id" value="<%=dto.getId()%>" readOnly></td>
			</tr>
			<tr>
				<th bgcolor="yellow">��й�ȣ</th>
				<td><input type="password" name="passwd" value="<%=dto.getPasswd()%>"></td>
			</tr>
			<tr>
				<th bgcolor="yellow">�ֹι�ȣ</th>
				<td><input type="text" name="ssn1" value="<%=dto.getSsn1()%>" readOnly>
					- <input type="password" name="ssn2" value="<%=dto.getSsn2()%>" readOnly></td>
			</tr>
			<tr>
				<th bgcolor="yellow">�̸���</th>
				<td><input type="text" name="email" value="<%=dto.getEmail()%>"></td>
			</tr>
			<tr>
				<th bgcolor="yellow">��ȭ��ȣ</th>
				<td><input type="text" name="hp1" size="3" maxlength="3" value="<%=dto.getHp1()%>">
					-<input type="text" name="hp2" size="4" maxlength="4" value="<%=dto.getHp2()%>">
					-<input type="text" name="hp3" size="4" maxlength="4" value="<%=dto.getHp3()%>"></td>
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