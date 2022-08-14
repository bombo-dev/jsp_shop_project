<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- list.jsp -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>글목록</title>
</head>
<body>
	<div align="center">
		<b>글 목 록</b>
		<table border="0" width="700">
			<c:if test="${member.id == 'admin'}">
			<tr bgcolor="yellow">
				<td align="right">
					<a href="notice_board_write.do">글쓰기</a>
				</td>
			</tr>
			</c:if>
		</table>
		<table border="1" width="700">
			<tr bgcolor="green">
				<th>번호</th>
				<th width="30%">제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회</th>
			</tr>
		<c:if test="${empty listBoard}">
			<tr>
				<td colspan="6">등록된 게시글이 없습니다.</td>				
			</tr>	
		</c:if>
		<c:forEach var="dto" items="${listBoard}">
			<tr>
				<td>${dto.num}</td>
				<td><a href="notice_board_content.do?num=${dto.num}">
					${dto.subject}
				</a></td>
				<td>${dto.writer}</td>
				<td>${dto.reg_date}</td>
				<td>${dto.readcount}</td>
			</tr>
		</c:forEach>		
		</table>
	</div>
</body>
</html>








