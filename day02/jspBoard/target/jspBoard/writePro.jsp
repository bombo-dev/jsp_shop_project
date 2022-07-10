<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-07-10
  Time: PM 3:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="bodto" class="Board.BoardDTO"/>
<jsp:setProperty name="bodto" property="*" />
<jsp:useBean id="bodao" class="Board.BoardDAO"/>

<%
    bodto.setIp(request.getRemoteAddr());
    int row = bodao.insertBoard(bodto);
    if(row != 0) { %>
<script type="text/javascript">
    alert("글등록이 완료되었습니다.");
    location.href="list.jsp"
</script>

<%} else { %>
<script type="text/javascript">
    alert("글등록이 실패하였습니다.");
    location.href="list.jsp"
</script>
<% } %>
%>
