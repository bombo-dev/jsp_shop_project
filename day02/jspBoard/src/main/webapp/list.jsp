<%@ page import="Board.BoardDTO" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-07-10
  Time: PM 2:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> 게시판 </title>
</head>
<% request.setCharacterEncoding("utf-8");%>
<jsp:useBean id="bodto" class="Board.BoardDTO"/>
<jsp:setProperty name="bodto" property="*"/>
<jsp:useBean id="bodao" class="Board.BoardDAO"/>
<body>
    <div align="center">
        <hr>
        <h2> 글 목 록 </h2>
        <div style="background-color: yellow">
            <a href="writeForm.jsp">글쓰기</a>
        </div>
        <table border="1" width="100%">
            <tr bgcolor="green">
                <th>번호</th>
                <th>제목</th>
                <th>작성자</th>
                <th>작성일</th>
                <th>조회수</th>
                <th>IP</th>
            </tr>
            <%
                List<BoardDTO> list = bodao.listBoard(bodto);
                if (list==null || list.size()==0){ %>
            <tr>
                <td colspan="6">등록된 게시글이 없습니다.</td>
            </tr>
            <% } else {
            for(BoardDTO dto: list){ %>
            <tr>
                <td><%=dto.getNum()%></td>
                <td><a href="context.jsp"><%=dto.getSubject()%></a></td>
                <td><%=dto.getWriter()%></td>
                <td><%=dto.getReg_date()%></td>
                <td><%=dto.getReadcount()%></td>
                <td><%=dto.getIp()%></td>
            </tr>
            <% }
            }
            %>
        </table>
    </div>
</body>
</html>
