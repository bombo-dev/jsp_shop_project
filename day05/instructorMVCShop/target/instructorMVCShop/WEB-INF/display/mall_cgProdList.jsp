<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-07-24
  Time: AM 8:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="mall_top.jsp" %>

<h3>Welcome to My Mall</h3>
<c:if test="${empty sessionScope.code}">
  <b>${cname} 상품이 없습니다</b><br>
</c:if>
<c:if test="${not empty sessionScope.code}">
  <b>${cname} 상품이 있습니다</b><br>
</c:if>
${sessionScope.code}

<%@ include file="mall_bottom.jsp"%>
