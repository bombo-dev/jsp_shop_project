<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- member_update.jsp -->
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
	<form name="f" action="member_update.do" 
						method="post" onsubmit="return check()">
		<input type="hidden" name="no" value="${getMember.no}"/>	
		<table border="1" width="80%">
			<tr>
				<th width="20%" bgcolor="yellow">�̸�</th>
				<td><input type="text" name="name" value="${getMember.name}" readOnly></td>
			</tr>
			<tr>
				<th bgcolor="yellow">���̵�</th>
				<td><input type="text" name="id" value="${getMember.id}" readOnly></td>
			</tr>
			<tr>
				<th bgcolor="yellow">��й�ȣ</th>
				<td><input type="password" name="passwd" value="${getMember.passwd}"></td>
			</tr>
			<tr>
				<th bgcolor="yellow">�ֹι�ȣ</th>
				<td><input type="text" name="ssn1" value="${getMember.ssn1}" readOnly>
					- <input type="password" name="ssn2" value="${getMember.ssn2}" readOnly></td>
			</tr>
			<tr>
				<th bgcolor="yellow">�̸���</th>
				<td><input type="text" name="email" value="${getMember.email}"></td>
			</tr>
			<tr>
				<th bgcolor="yellow">��ȭ��ȣ</th>
				<td><input type="text" name="hp1" size="3" maxlength="3" value="${getMember.hp1}">
					-<input type="text" name="hp2" size="4" maxlength="4" value="${getMember.hp2}">
					-<input type="text" name="hp3" size="4" maxlength="4" value="${getMember.hp3}"></td>
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