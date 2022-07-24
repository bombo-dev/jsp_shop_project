<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-07-16
  Time: PM 2:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String msg = (String)request.getAttribute("msg");
  String url = (String)request.getAttribute("url");
%>
<script>
  alert("<%=msg%>")
  location.href="<%=url%>"
</script>
