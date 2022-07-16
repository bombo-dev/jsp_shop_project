<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.util.*, student.*"%>
<!-- list.jsp -->
<html>
<head>
	<title>학생목록</title>
</head>
<%
		List<StudentDTO> listStudent = (List)request.getAttribute("listStudent");
%>
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
<%		if (listStudent==null || listStudent.size()==0){%>
			<tr>
				<td colspan="3">등록된 학생이 없습니다.</td>
			</tr>		
<% 		}else {
			for(StudentDTO dto: listStudent){%>
			<tr>
				<td><%=dto.getId()%></td>
				<td><%=dto.getName()%></td>
				<td><%=dto.getCname()%></td>
			</tr>
<%			}
		}	
%>			
		</table>
	</div>
</body>
</html>





