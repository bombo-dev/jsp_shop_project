<%--
  Created by IntelliJ IDEA.
  User: munjong-un
  Date: 2022/07/31
  Time: 12:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>회원관리</title>
</head>
<body>
<div align="center">
  <table border="1" width="600" height="500">
    <tr height="10%">
      <th>
        <c:if test="${isLogin == true}">
          <a href="logout.do">로그아웃</a>
        </c:if>
        <c:if test="${isLogin == false}">
          <a href="login.do">로그인</a>
        </c:if>
      </th>
      <th><a href="memberSsn.do">회원가입</a></th>
      <th><a href="memberAll.do">회원보기</a></th>
      <th><a href="memberAll.do?mode=find">회원찾기</a></th>
    </tr>
    <tr height="80%">
      <td width="100%" height="100%" colspan="4">
