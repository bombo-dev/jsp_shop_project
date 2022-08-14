<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- memberAll.jsp -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div align="center">
	<hr color="green" width="300">
		<h2>ȸ �� �� �� �� ��</h2>
	<form action="member_list.do" method="post">
		<input type="hidden" name="mode" value="find"/>
		<select name="search">
			<option value="id">���̵�</option>
			<option value="name">�̸�</option>
		</select>
		<input type="text" name="searchString">
		<input type="submit" value="ã��">
	</form>

	<hr color="green" width="300">
	<table border="1" width="100%">
		<tr bgcolor="yellow">
			<th>��ȣ</th>
			<th>�̸�</th>
			<th>���̵�</th>
			<th>�̸���</th>
			<th>��ȭ��ȣ</th>
			<th>������</th>
			<th>����</th>
		</tr>
	<c:if test="${empty listMember}">
		<tr>
			<td colspan="7">��ϵ� ȸ���� �����ϴ�.</td>
		</tr>
	</c:if>	
	<c:forEach var="dto" items="${listMember}">
		<tr>
			<td>${dto.no}</td>
			<td>${dto.name}</td>
			<td>${dto.id}</td>
			<td>${dto.email}</td>
			<td>${dto.allHp}</td>
			<td>${dto.joindate}</td>
			<td>	<a href="member_delete.do?no=${dto.no}">����</a></td>
		</tr>	
	</c:forEach>
	</table>
</div>











