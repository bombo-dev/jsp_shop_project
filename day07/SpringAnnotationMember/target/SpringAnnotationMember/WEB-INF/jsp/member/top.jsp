<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-07-30
  Time: AM 11:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- top.jsp -->
<html>
<head>
    <title>회원관리</title>
</head>
<body>
<div align="center">
    <table border="1" width="600" height="500">
        <tr height="10%">
<%--            <th>--%>
<%--                <%if (isLogin){ %>--%>
<%--                <a href="logout.do">로그아웃</a>--%>
<%--                <%}else{ %>--%>
<%--                <a href="login.do">로그인</a>--%>
<%--                <%}%>--%>
<%--            </th>--%>
            <th><a href="memberSsn.do">회원가입</a></th>
            <th><a href="memberAll.do">회원보기</a></th>
            <th><a href="memberAll.do?mode=find">회원찾기</a></th>
        </tr>
        <tr height="80%">
            <td width="100%" height="100%" colspan="4">
