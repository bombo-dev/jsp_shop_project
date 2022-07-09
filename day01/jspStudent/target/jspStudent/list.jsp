<%@ page import="java.util.List" %>
<%@ page import="StudentDTO" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-07-09
  Time: PM 4:02
  To change this template use File | Settings | File Templates.
--%>
<%-- list.jsp --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>학생목록</title>
</head>
<jsp:useBean id="StudentDTO" class="StudentDTO"/>
<jsp:useBean id="stdao" class="StudentDAO"/>
<body>
    <div align="center">
        <hr color="green" width="300">
        <h2>학생목록 보기</h2>
        <hr color="green" width="300">
        <table border="1" width="500">
            <tr>
                <th>아이디</th>
                <th>학생명</th>
                <th>학급명</th>
            </tr>
            <% List<StudentDTO> list = stdao.listStudent()
                if(list==null || list.size()==0){ %>
                <tr>
                    <td colspan="3">등록된 학생이 없습니다.</td>
                </tr>
            <% } else {
                    for(StudentDTO dto: list){%>
                <tr>
                    <td><%=dto.getId()%></td>
                    <td><%=dto.getName()%></td>
                    <td><%=dto.getCname()%></td>
            <% } %>
        </table>
    </div>
</body>
</html>
