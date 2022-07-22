<%--
  Created by IntelliJ IDEA.
  User: munjong-un
  Date: 2022/07/09
  Time: 11:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>찾은 학생 정보 보기</title>
</head>

<body>

<div align="center">
    <hr color="green" width="300">
    <h2>학 생 목 록 보 기</h2>
    <hr color="green" width="300">
    <table border="1" width="500">
        <tr>
            <th>아이디</th>
            <th>학생명</th>
            <th>학급명</th>
        </tr>

        <c:set var="dto" value="${findStudent}"/>

        <c:choose>
            <c:when test="${empty dto}">
                <tr>
                    <td colspan="3">검색한 학생 정보를 찾을 수 없습니다.</td>
                </tr>
            </c:when>

            <c:otherwise>
                <tr>
                    <td>${dto.id}</td>
                    <td>${dto.name}</td>
                    <td>${dto.cname}</td>
                </tr>
            </c:otherwise>
        </c:choose>
    </table>
</div>
</body>
</html>
