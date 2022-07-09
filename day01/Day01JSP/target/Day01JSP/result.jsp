<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-07-09
  Time: PM 2:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!-- result.jsp -->

<%
    String id = request.getParameter("id");
%>

<script type="text/javascript">
    alert("<%= id%>" 님 반갑습니다.)
</script>

