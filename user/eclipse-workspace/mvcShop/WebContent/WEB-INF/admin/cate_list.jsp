<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ include file = "top.jsp" %>
	<table border="1" width="500">
		<caption>ī �� �� �� �� ��</caption>
		<tr>
			<th>��ȣ</th> 
			<th>ī�װ��ڵ�</th>
			<th>ī�װ��̸�</th>
			<th>����</th>
		</tr>
	<c:if test="${empty listCate}">
		<tr>
			<td colspan="4">
				��ϵ� ī�װ��� �����ϴ�.
			</td>
		</tr>
	</c:if>		
	<c:forEach var="dto" items="${listCate}">
		<tr>
			<td>${dto.cnum}</td>	
			<td>${dto.code}</td>
			<td>${dto.cname}</td>
			<td><a href="cate_delete.mall?cnum=${dto.cnum}">����</a>
			</td>
		</tr>
	</c:forEach>
	</table>
<%@ include file = "bottom.jsp" %>









