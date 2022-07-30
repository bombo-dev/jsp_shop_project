<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<!-- memberAll.jsp -->
<%@ include file="top.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div align="center">
	<hr color="green" width="300">
	<c:if test="${mode == 'all'}">
		<h2>회 원 목 록 보 기</h2>
	</c:if>
	<c:if test="${mode != 'all'}">
	<h2>회 원 찾 기</h2>
	<form action="memberAll.do" method="post">
		<input type="hidden" name="mode" value="find"/>
		<select name="search">
			<option value="id">아이디</option>
			<option value="name">이름</option>
		</select>
		<input type="text" name="searchString">
		<input type="submit" value="찾기">
	</form>
	</c:if>
	<hr color="green" width="300">
	<table border="1" width="100%">
		<tr bgcolor="yellow">
			<th>번호</th>
			<th>이름</th>
			<th>아이디</th>
			<th>이메일</th>
			<th>전화번호</th>
			<th>가입일</th>
			<th>수정|삭제</th>
		</tr>
	<c:if test="${empty list}">
		<tr>
			<td colspan="7">등록된 회원이 없습니다.</td>
		</tr>
	</c:if>	
	<c:forEach var="dto" items="${list}">
		<tr>
			<td>${dto.no}</td>
			<td>${dto.name}</td>
			<td>${dto.id}</td>
			<td>${dto.email}</td>
			<td>${dto.allHp}</td>
			<td>${dto.joindate}</td>
			<td><a href="member_update.do?no=${dto.no}">수정</a> | 
			<a href="member_delete.do?no=${dto.no}">삭제</a></td>
		</tr>	
	</c:forEach>
	</table>
</div>
<%@ include file="bottom.jsp"%>










