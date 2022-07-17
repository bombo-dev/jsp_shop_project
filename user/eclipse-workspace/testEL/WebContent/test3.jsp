<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>JSTL 예제 2</title>
</head>
<body>
<c:set var="country" value="${'korea'}" />
<c:if test="${not empty country}"><%-- not empty는 != 과 같은 효과 --%>
국가명 : <c:out value="${country}" />
</c:if>
</body>
</html>
