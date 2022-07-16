<%@ page import="Board.BoardDTO" %><%--
  Created by IntelliJ IDEA.
  User: munjong-un
  Date: 2022/07/14
  Time: 1:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="bodao" class="Board.BoardDAO"/>
<%
    String num = request.getParameter("num");
    if ( num == null || num.trim().equals("")){
        response.sendRedirect("index.jsp");
        return;
    }

    BoardDTO dto = bodao.getBoard(Integer.parseInt(num), "content");
%>
<html>
<head>
    <title>글 내용 보기</title>
</head>
<body>
    <div align="center">
        <b>글내용 보기</b>
        <br>

        <table border="1" width="600">
            <tr>
                <th width="20%" bgcolor="yellow">글번호</th>
                <td align="center" width="30%"><%=dto.getNum()%></td>
                <th width="20%" bgcolor="yellow">조회수</th>
                <td align="center" width="30%"><%=dto.getReadcount()%></td>
            </tr>
            <tr>
                <th width="20%" bgcolor="yellow">작성자</th>
                <td align="center" width="30%"><%=dto.getWriter()%></td>
                <th width="20%" bgcolor="yellow">작성일</th>
                <td align="center" width="30%"><%=dto.getReg_date()%></td>
            </tr>
            <tr>
                <th width="20%" bgcolor="yellow">글 제목</th>
                <td align="center" colspan="3" width="80%"><%=dto.getSubject()%></td>
            </tr>
            <tr>
                <th width="20%" bgcolor="yellow">글 내용</th>
                <td align="center" colspan="3" width="80%"><%=dto.getContent()%></td>
            </tr>
            <tr bgcolor="yellow">
                <td align="right" colspan="4">
                    <input type="button" value="글 수정"
                    onclick = "window.location='updateForm.jsp?num=<%=dto.getNum()%>'">
                    <input type="button" value="글 삭제"
                    onclick = "window.location='deleteForm.jsp?num=<%=dto.getNum()%>'">
                    <input type="button" value="글 목록"
                    onclick = "window.location='list.jsp'">
                </td>
            </tr>
        </table>
    </div>
</body>
</html>
