<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-07-10
  Time: PM 2:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>글쓰기</title>
</head>
<body>
<form name="f" action="writePro.jsp" method="post">
    <table border="1" width="80%">
        <tr align="center" bgcolor="yellow" colspan="6">글쓰기</tr>
        <tr>
            <th bgcolor="yellow">이 름</th>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <th bgcolor="yellow">제목</th>
            <td width="70%"><input type="text" name="subject"></td>
        </tr>
        <tr>
            <th bgcolor="yellow">Email</th>
            <td width="70%"><input type="text" name="email"></td>
        </tr>
        <tr width ="70%" height = "200">
            <th bgcolor="yellow">내용</th>
            <td height = "200"><input type="text" name="content" style="width:100%; height: 300px"></td>
        </tr>
        <tr>
            <th bgcolor="yellow">비밀번호</th>
            <td><input type="password" name="passwd"></td>
        </tr>
        <tr>
            <td align="center" colspan="2" bgcolor="yellow">
                <input type="submit" value="작성 완료">
                <input type="reset" value="다시 작성">
                <a href="list.jsp"><input type="button" value="목록보기"></a>
            </td>
        </tr>

    </table>
</form>

</body>
</html>
