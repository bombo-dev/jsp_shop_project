<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="mall_top.jsp" %>
<c:if test="${empty cart}">
	<script type="text/javascript">
		alert("��ٱ��Ͽ� ��ǰ�� �����ϴ�.");
		location.href="displayShop.mall";
	</script>
</c:if>
<c:if test="${not empty cart}">
	<table border="1">
		<tr>
			<th colspan="6">
				��ٱ��� ����
			</th>
		</tr>
		<tr>
			<th>��ȣ</th>
			<th>��ǰ��</th>
			<th>����</th>
			<th>�ܰ�</th>
			<th>�ݾ�</th>
			<th>����</th>
		</tr>
		<c:set var="cartTotalPrice" value="0"/>
		<c:set var="cartTotalPoint" value="0"/>
	<c:forEach var="dto" items="${cart}">	
		<tr>
			<td>${dto.pnum}</td>
			<td>
				<img src="prodImage/${dto.pimage}" width="40" height="40"><br>
				${dto.pname}
			</td>	
			<td>
				<form name="f" method="post" action="cartEdit.mall">
					<input type="text" name="qty" value="${dto.pqty}" size="3"> ��
					<input type="hidden" name="pnum" value="${dto.pnum}">
					<br><input type="submit" value="����">
				</form>	
			</td>
			<td>
				${dto.price}��<br>
				[${dto.point}] point
			</td>
			<td>
				${dto.price * dto.pqty}��<br>
				[${dto.point * dto.pqty}] point
				<c:set var="cartTotalPrice" value="${cartTotalPrice + (dto.price*dto.pqty)}"/>
				<c:set var="cartTotalPoint" value="${cartTotalPoint + (dto.point*dto.pqty)}"/>
			</td>	
			<td>
				<a href="cartDel.mall?pnum=${dto.pnum}">����</a>
			</td>
		</tr>
		<tr class="m1">
			<td colspan="4">
				<b>��ٱ����Ѿ� : </b>
				<font color="red">${cartTotalPrice}��</font><br>
				<font color="green">�� ���� ����Ʈ : ${cartTotalPoint}point</font>
			</td>
			<td colspan="2">
				[<a href="order.mall">�ֹ��ϱ�</a>]
				[<a href="displayShop.mall">��Ӽ���</a>]
			</td>
		</tr>
	</c:forEach>
</table>
</c:if>
<%@ include file="mall_bottom.jsp" %>







