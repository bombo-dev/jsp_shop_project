<%@ page import="Board.BoardDTO" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-07-10
  Time: PM 4:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>글 내용 보기</title>
</head>
<% request.setCharacterEncoding("utf-8");
    String num = request.getParameter("num");
%>

<jsp:useBean id="bodao" class="Board.BoardDAO"/>

<% BoardDTO board = bodao.contextBoard(Integer.parseInt(num)); %>
<body>
<h3 align="center">글 내용 보기</h3>
<table>
    <tr>
        <th bgcolor="yellow">글 번호</th>
        <td><%=board.getNum()%></td>

        <th bgcolor="yellow">조회수</th>
        <td><%=board.getReadcount()%></td>
    </tr>
    <tr>
        <th bgcolor="yellow">작성자</th>
        <td><%=board.getWriter()%></td>
        <th bgcolor="yellow">작성일</th>
        <td><%=board.getReg_date()%></td>
    </tr>
    <tr>
        <th bgcolor="yellow">글제목</th>
        <td colspan="3"><%=board.getSubject()%></td>
    </tr>
</table>
</body>
</html>
