<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-07-24
  Time: AM 8:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- message.jsp -->
<%
    String msg = (String)request.getAttribute("msg");
    String url = (String)request.getAttribute("url");
%>
<script type="text/javascript">
    alert("<%=msg%>")
    location.href="<%=url%>"
</script>
