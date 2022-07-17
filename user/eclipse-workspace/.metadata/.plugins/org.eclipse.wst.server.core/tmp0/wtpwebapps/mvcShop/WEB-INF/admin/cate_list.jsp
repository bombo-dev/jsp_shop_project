<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ include file = "top.jsp" %>
	<table border="1" width="500">
		<caption>카 테 고 리 목 록</caption>
		<tr>
			<th>번호</th> 
			<th>카테고리코드</th>
			<th>카테고리이름</th>
			<th>삭제</th>
		</tr>
	<c:if test="${empty listCate}">
		<tr>
			<td colspan="4">
				등록된 카테고리가 없습니다.
			</td>
		</tr>
	</c:if>		
	<c:forEach var="dto" items="${listCate}">
		<tr>
			<td>${dto.cnum}</td>	
			<td>${dto.code}</td>
			<td>${dto.cname}</td>
			<td><a href="cate_delete.mall?cnum=${dto.cnum}">삭제</a>
			</td>
		</tr>
	</c:forEach>
	</table>
<%@ include file = "bottom.jsp" %>









