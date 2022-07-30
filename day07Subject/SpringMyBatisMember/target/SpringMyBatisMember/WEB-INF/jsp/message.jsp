<%--
  Created by IntelliJ IDEA.
  User: munjong-un
  Date: 2022/07/31
  Time: 12:45 AM
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
