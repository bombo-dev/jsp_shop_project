<%--
  Created by IntelliJ IDEA.
  User: munjong-un
  Date: 2022/07/14
  Time: 1:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="bodto" class="Board.BoardDTO"/>
<jsp:setProperty name="bodto" property="*"/>
<jsp:useBean id="bodao" class="Board.BoardDAO"/>

<%
    if(bodto.getWriter()==null || bodto.getWriter().trim().equals("")){
        response.sendRedirect("index.jsp");
        return;
    }

    bodto.setIp(request.getRemoteAddr());
    int res = bodao.insertBoard(bodto);

    if (res > 0){ %>
    <script>
        alert("게시글 등록 성공!! 게시글 목록 페이지로 이동합니다.")
        location.href="list.jsp"
    </script>
<% } else {%>
    <script>
        alert("게시글 등록 실패!! 게시글 등록 페이지로 이동합니다.")
        location.href="writeForm.jsp"
    </script>
<% } %>

