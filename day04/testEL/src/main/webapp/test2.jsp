<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-07-17
  Time: PM 1:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- test.jsp -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>JSTL 예제 1</title>
</head>
<body>
browser변수값 설정
<c:set var="browser" value="${header['User-Agent']}" /><br>
설정후 browser : <c:out value="${browser}" /><p>
    <c:remove var="browser" />
    삭제후 browser : <c:out value="${browser}" />
</body>
</html>

