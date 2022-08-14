<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- list.jsp -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>�۸��</title>
</head>
<body>
	<div align="center">
		<b>�� �� ��</b>
		<table border="0" width="700">
			<c:if test="${member.id == 'admin'}">
			<tr bgcolor="yellow">
				<td align="right">
					<a href="notice_board_write.do">�۾���</a>
				</td>
			</tr>
			</c:if>
		</table>
		<table border="1" width="700">
			<tr bgcolor="green">
				<th>��ȣ</th>
				<th width="30%">����</th>
				<th>�ۼ���</th>
				<th>�ۼ���</th>
				<th>��ȸ</th>
			</tr>
		<c:if test="${empty listBoard}">
			<tr>
				<td colspan="6">��ϵ� �Խñ��� �����ϴ�.</td>				
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








