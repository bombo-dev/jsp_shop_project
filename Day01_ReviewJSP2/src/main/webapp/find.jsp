<%@ page import="Student.StudentDTO" %>
<%@ page import="Student.StudentDAO" %>
<%--
  Created by IntelliJ IDEA.
  User: munjong-un
  Date: 2022/07/09
  Time: 11:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>찾은 학생 정보 보기</title>
</head>
<% request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="stdto" class="Student.StudentDTO"/>
<jsp:setProperty name="stdto" property="*"/>
<%--<jsp:useBean id="stdao" class="Student.StudentDAO"/>--%>
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
            <% StudentDAO stdao = new StudentDAO();
                StudentDTO dto = stdao.selectOne(stdto);
            if(dto == null) {%>
            <tr>
                <td colspan="3">검색한 학생 정보를 찾을 수 없습니다.</td>
            </tr>
                <% }else { %>
                <tr>
                    <td><%=dto.getId()%></td>
                    <td><%=dto.getName()%></td>
                    <td><%=dto.getCname()%></td>
                </tr>
            <%} %>
        </table>
    </div>
</body>
</html>
