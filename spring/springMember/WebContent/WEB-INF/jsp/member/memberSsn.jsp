<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- memberSsn.jsp -->
<%@ include file="top.jsp"%>
<div align="center">
	<hr color="green" width="300">
	<h2>ȸ �� �� �� �� ��</h2>
	<hr color="green" width="300">
	<form name="f" action="member_check.do" method="post">
		<table border="1" width="500">
			<tr>
				<th width="20%">�̸�</th>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<th width="20%">�ֹι�ȣ</th>
				<td><input type="text" name="ssn1" maxlength="6">
				- <input type="password" name="ssn2" maxlength="7">	
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="��ȸ">
					<input type="reset" value="���">
				</td>
			</tr>
		</table>
	</form>
</div>
<%@ include file="bottom.jsp"%>