<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- view_carName.jsp -->

<form name="f" action="carName_update.do" method="post">
	<input type="hidden" name="num" value="${getCarName.num}">
	<table border="1" width="500" height="150">
	<caption>��Ʈī ���� ����</caption>
	<tr>
		<th bgcolor="yellow">�����ڵ��ȣ</th>
		<td>${getCarName.carCode}</td>
	</tr>
	<tr>
		<th bgcolor="yellow">��Ʈ����</th>
		<td>${getCarName.carName}</td>
	</tr>
	<tr>
		<th bgcolor="yellow">����</th>
		<td>${getCarName.carType}</td>
	</tr>
	<tr>
		<th bgcolor="yellow">����</th>
		<td>${getCarName.carFuel}</td>
	</tr>
	<tr>
		<th bgcolor="yellow">��������</th>
		<td><textarea name="carInfo" rows="7" cols="50">${getCarName.carInfo}</textarea></td>
	</tr>
	<tr>
		<th bgcolor="yellow">������</th>
		<td>${getCarName.carCompany}</td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="submit" value="����">
			<input type="button" value="���" onclick="location.href='carName_list.do'">
		</td>
	</tr>	
	</table>
</form>