<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<form name="f" action="carName_input.do" method="post">
	<table border="1" width="500" height="150">
	<caption>��Ʈī ���� ���</caption>
	<tr>
		<th bgcolor="yellow">�����ڵ��ȣ</th>
		<td><input type="text" name="carCode"></td>
	</tr>
	<tr>
		<th bgcolor="yellow">��Ʈ����</th>
		<td><input type="text" name="carName"></td>
	</tr>
	<tr>
		<th bgcolor="yellow">����</th>
		<td>
			<select name="carType">
				<option>����</option>
				<option>����</option>
				<option>����</option>
				<option>����</option>
				<option>SUV</option>
				<option>����</option>
				<option>����</option>
			</select>
		</td>
	</tr>
	<tr>
		<th bgcolor="yellow">����</th>
		<td>
			<select name="carFuel">
				<option>�ֹ���</option>
				<option>����</option>
				<option>LPG</option>
				<option>����</option>
				<option>����</option>
				<option>hibrid</option>
			</select>
		</td>
	</tr>
	<tr>
		<th bgcolor="yellow">��������</th>
		<td><textarea name="carInfo" rows="7" cols="50"></textarea></td>
	</tr>
	<tr>
		<th bgcolor="yellow">������</th>
		<td><input type="text" name="carCompany"></td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="submit" value="���">
			<input type="reset" value="���">
		</td>
	</tr>	
	</table>
</form>