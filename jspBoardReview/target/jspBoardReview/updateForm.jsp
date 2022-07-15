<%--
  Created by IntelliJ IDEA.
  User: munjong-un
  Date: 2022/07/15
  Time: 12:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% request.setCharacterEncoding("utf-8");
    String num = request.getParameter("num");
    if(num == null || num.trim().equals("")){
        response.sendRedirect("index.jsp");
        return ;
    }
%>
<html>
<head>
    <title>글 수정</title>
</head>
<body>
    <div align="center">
        <b>글 수정</b>
        <br>
        <form id ="f" action="updatePassCheck.jsp" method="post">
            <input type="hidden" name="num" value="<%=num%>">
            <table border="1" width="300">
                <tr bgcolor="yellow">
                    <th>비밀번호를 입력해주세요.</th>
                </tr>
                <tr>
                    <td align="center">
                        비밀번호 : <input type="password" name="passwd">
                    </td>
                </tr>
                <tr bgcolor="yellow">
                    <td align="center">
                        <input type="submit" value="글 수정">
                        <input type="button" value="글 목록" onclick="window.location='list.jsp'">
                    </td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>
