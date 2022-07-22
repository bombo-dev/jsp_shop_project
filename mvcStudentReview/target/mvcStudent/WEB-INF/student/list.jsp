<%@ page import="student.DTO.StudentDTO" %>
<%@ page import="java.util.List" %>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- list.jsp -->
<html>
<head>
	<title>학생목록</title>
</head>

<body>

	<div align="center">
		<hr color="green" width="300">
		<h2>학 생 목 록 보 기</h2>
		<hr color="green" width="300">
		<table border="1" width="500">
			<tr>
				<th>아이디</th>
				<th>학생명</th>
				<th>학급명</th>
			</tr>		
<%--//여기에 DB에서 자료를 가져와 출력하는 프로그램 만들어야 한다.--%>
			<c:if test="${empty listStudent}">
				<tr>
					<td colspan="3">등록된 학생이 없습니다.</td>
				</tr>
			</c:if>
			<c:forEach var="dto" items="${listStudent}">
				<tr>
					<td>${dto.id}</td>
					<td>${dto.name}</td>
					<td>${dto.cname}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>





