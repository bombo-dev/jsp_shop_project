<%--
  Created by IntelliJ IDEA.
  User: munjong-un
  Date: 2022/07/15
  Time: 1:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% request.setCharacterEncoding("utf-8");
    String num = request.getParameter("num");

    if (num == null || num.trim().equals("")) {
        response.sendRedirect("index.jsp");
        return;
    } // 내일 질문
%>
<jsp:useBean id="bodto" class="Board.BoardDTO"/>
<jsp:setProperty name="bodto" property="*"/>
<jsp:useBean id="bodao" class="Board.BoardDAO"/>
<%
    int res = bodao.updateBoard(Integer.parseInt(num), bodto);
    if (res > 0) {%>
<script type="text/javascript">
    alert("게시글수정 성공!! 해당 게시글로 이동합니다.")
    location.href = "content.jsp?num=<%=num%>"
</script>
<% } else {%>
<script type="text/javascript">
    alert("게시글수정 실패!! 해당 게시글로 이동합니다.")
    location.href = "content.jsp?num=<%=num%>"
</script>
<% }%>

