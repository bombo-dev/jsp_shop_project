<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- member_input.jsp -->
<link rel="stylesheet" type="text/css" href="resources/style.css">
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
	<form name="f" action="member_input_ok.do" 
			method="post" onsubmit="return check()">
		<table width="80%" class="outline">
			<tr>
				<td colspan="2" align=center class="m2">ȸ������</td>
			</tr>
			<tr>
				<th width="20%" class="m3">�̸�</th>
				<td><input type="text" class="box" name="name" value="${param.name}" readOnly></td>
			</tr>
			<tr>
				<th class="m3">���̵�</th>
				<td><input type="text" class="box" name="id"></td>
			</tr>
			<tr>
				<th class="m3">��й�ȣ</th>
				<td><input type="password" class="box" name="passwd"></td>
			</tr>
			<tr>
				<th class="m3">�ֹι�ȣ</th>
				<td><input type="text" class="box" name="ssn1" value="${param.ssn1}" readOnly>
					- <input type="password" class="box" name="ssn2" value="${param.ssn2}" readOnly></td>
			</tr>
			<tr>
				<th class="m3">�̸���</th>
				<td><input type="text" class="box" name="email"></td>
			</tr>
			<tr>
				<th class="m3">��ȭ��ȣ</th>
				<td><input type="text" name="hp1" class="box" size="3" maxlength="3">
					-<input type="text" name="hp2" class="box" size="4" maxlength="4">
					-<input type="text" name="hp3" class="box" size="4" maxlength="4"></td>
			</tr>
			<tr>
				<td align="center" colspan="2" class="m2">
					<input type="submit" value="ȸ������">
					<input type="reset" value="�ٽ��Է�">
				</td>
			</tr>
		</table>
	</form>
</div>
