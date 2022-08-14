<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- list_carName.jsp -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<table border="1" width="500">
	<caption>차 량 목 록</caption>
	<tr>
		<th>번호</th> 
		<th>차종코드</th>
		<th>차량명</th>
		<th>삭제</th>
	</tr>
<c:if test="${empty listCarName}">
		<tr>
			<td colspan="4">
				등록된 차종이 없습니다.
			</td>
		</tr>
	</c:if>		
	<c:forEach var="dto" items="${listCarName}">
		<tr>
			<td>${dto.num}</td>	
			<td>${dto.carCode}</td>
			<td><a href="carName_view.do?num=${dto.num}">${dto.carName}</a></td>
			<td><a href="carName_delete.do?num=${dto.num}">삭제</a>
			</td>
		</tr>
	</c:forEach>
	</table>
	<a href="index.do">처음화면으로</a>