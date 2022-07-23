<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="mall_top.jsp" %>

<h3>Welcome to My Mall</h3> 
	<c:if test="${empty sessionScope.code}">
		<b>${cname} 상품이 없습니다</b><br>
	</c:if>
	<c:if test="${not empty sessionScope.code}">
		<b>${cname} 상품이 있습니다</b><br>
	</c:if>
	${sessionScope.code}

<%@ include file="mall_bottom.jsp"%>