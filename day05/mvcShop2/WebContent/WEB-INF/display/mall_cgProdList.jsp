<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="mall_top.jsp" %>
<c:if test="${empty sessionScope[requestScope.code]}">
	<b>${requestScope.cname} 상품이 없습니다</b><br>
</c:if>
<c:if test="${not empty sessionScope[requestScope.code]}">
	<hr color="green" width="80%">
	<font color="red" size="3">${requestScope.cname}</font>
	<hr color="green" width="80%">
	<br>
</c:if>
<table width="100%" border="0" align="center">
	<tr>
		<c:set var="count" value="0"/>
		<c:forEach var="dto" items="${sessionScope[requestScope.code]}">
			<c:set var="count" value="${count+1}"/>
			<td align="center">
				<a href="prodView.mall?pnum=${dto.pnum}&select=${code}">
					<img src="prodImage/${dto.pimage}" width="80" height="60" border="0">
				</a><br>
				${dto.pname}<br>
				<font color="red">${dto.price}</font>원<br>
				<font color="blue">[${dto.point}]</font>point
			</td>	
			<c:if test="${count%3==0}">
				</tr><tr>
			</c:if>
		</c:forEach>
	</tr>
</table>

<%@ include file="mall_bottom.jsp"%>