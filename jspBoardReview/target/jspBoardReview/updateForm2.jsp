<%@ page import="board.BoardDTO" %><%--
  Created by IntelliJ IDEA.
  User: munjong-un
  Date: 2022/07/15
  Time: 12:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% request.setCharacterEncoding("utf-8");
    String num = request.getParameter("num");
    if (num == null || num.trim().equals("")) {
        response.sendRedirect("index.jsp");
        return;
    }
%>
<jsp:useBean id="bodao" class="board.BoardDAO"/>
<%
    BoardDTO dto = bodao.getBoard(Integer.parseInt(num), "update");
%>
<html>
<head>
    <title>글 수정</title>
    <script>
        function check() {
            if (f.subject.value == "") {
                alert("제목을 입력해주세요.")
                f.subject.focus()
                return false
            }
            if (f.email.value == "") {
                alert("이메일을 입력해주세요.")
                f.email.focus()
                return false
            }
            if (f.content.value == "") {
                alert("내용을 입력해주세요.")
                f.content.focus()
                return false
            }
            return true
        }
    </script>
</head>
<body>
<div align="center">
    <b>글수정</b>
    <br>
    <form id="f" action="updatePro.jsp" method="post" onsubmit="return check()">
        <input type="hidden" name="num" value="<%=num%>">
        <table border="1" width="600">
            <tr>
                <th width="20%" bgcolor="yellow">이 름</th>
                <td><input type="text" name="writer" value="<%=dto.getWriter()%>" readonly></td>
            </tr>
            <tr>
                <th width="20%" bgcolor="yellow">제 목</th>
                <td><input type="text" size="60" name="subject" value="<%=dto.getSubject()%>"></td>
            </tr>
            <tr>
                <th width="20%" bgcolor="yellow">Email</th>
                <td><input type="text" size="60" name="email"></td>
            </tr>
            <tr>
                <th width="20%" bgcolor="yellow">내 용</th>
                <td><textarea name="content" rows="13" cols="60" style="overflow: auto"></textarea></td>
            </tr>
            <tr bgcolor="yellow">
                <td colspan="2" bgcolor="yellow" align="center">
                    <input type="submit" value="글 수정">
                    <input type="reset" value="다시 작성">
                    <input type="button" value="목록 보기" onclick="window.location='list.jsp'">
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
