<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-07-17
  Time: AM 11:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<!-- deleteForm.jsp -->
<html>
<head>
    <title>글삭제</title>
</head>
<body>
<div align="center">
    <b>글삭제</b><br><br>
    <form name="f" action="board_delete.do" method="post">
        <input type="hidden" name="num" value="${param.num}"/>
        <table border="1" width="300">
            <tr bgcolor="yellow">
                <th>비밀번호를 입력해 주세요</th>
            </tr>
            <tr>
                <td align="center">
                    비밀번호 : <input type="password" name="passwd">
                </td>
            </tr>
            <tr bgcolor="yellow">
                <td align="center">
                    <input type="submit" value="글삭제">
                    <input type="button" value="글목록"
                           onclick="window.location='board_list.do'">
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
