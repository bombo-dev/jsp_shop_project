<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- mall_order.jsp -->
<%@ include file="mall_top.jsp" %>
<div align="center">
	<table border="1" width="80%">
		<tr>
			<td colspan="4" align="center"><b>���� ������ ����</b></td>
		</tr>
		<tr>
			<th width="50%">��ǰ��</th>
			<th width="10%">����</th>
			<th width="20%">�ܰ�</th>
			<th width="20%">�ݾ�</th>
		</tr>
		<c:set var="totalPrice" value="0"/>
		<c:forEach var="dto" items="${order}">
		<tr>
			<td>${dto.pname}</td>
			<td>${dto.pqty}</td>
			<td>${dto.price}</td>
			<td>${dto.price*dto.pqty}</td>
			<c:set var="totalPrice" value="${totalprice+(dto.price*dto.pqty)}"/>
		</tr>
		</c:forEach>
		<tr>
			<td colspan="4" align="center">
				<b>�����Ͻ� �Ѿ��� ${totalPrice}�� �Դϴ�</b>
			</td>
		</tr>
	</table>
</div>
<%@ include file="mall_bottom.jsp" %>