<%--
  Created by IntelliJ IDEA.
  User: munjong-un
  Date: 2022/07/15
  Time: 12:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% request.setCharacterEncoding("utf-8");
    String num = request.getParameter("num");
    String passwd = request.getParameter("passwd");
%>
<jsp:useBean id="bodao" class="board.BoardDAO"/>
<% int res = bodao.passwdCheck(Integer.parseInt(num), passwd);
    if(res > 0) {%>
    <script>
        alert("패스워드가 일치합니다. 게시글 수정으로 이동합니다.")
        location.href = 'updateForm2.jsp?num=<%=num%>'
    </script>
<% } else { %>
    <script>
        alert("패스워드가 일치하지 않습니다. 이전 페이지로 이동합니다.")
        history.back()
    </script>
<% } %>
