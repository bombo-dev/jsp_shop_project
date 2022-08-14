<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- list_carName.jsp -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<table border="1" width="500">
	<caption>�� �� �� ��</caption>
	<tr>
		<th>��ȣ</th> 
		<th>�����ڵ�</th>
		<th>������</th>
		<th>����</th>
	</tr>
<c:if test="${empty listCarName}">
		<tr>
			<td colspan="4">
				��ϵ� ������ �����ϴ�.
			</td>
		</tr>
	</c:if>		
	<c:forEach var="dto" items="${listCarName}">
		<tr>
			<td>${dto.num}</td>	
			<td>${dto.carCode}</td>
			<td><a href="carName_view.do?num=${dto.num}">${dto.carName}</a></td>
			<td><a href="carName_delete.do?num=${dto.num}">����</a>
			</td>
		</tr>
	</c:forEach>
	</table>
	<a href="index.do">ó��ȭ������</a>