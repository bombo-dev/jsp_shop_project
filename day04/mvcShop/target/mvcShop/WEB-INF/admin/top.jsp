<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-07-17
  Time: PM 2:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>TOP</title>
</head>
<body>
<div align="center">
    <h2 style="color:blue">쇼핑몰(관리자용)</h2>
    <a href="#" style="color:red">쇼핑몰 홈</a> / <a href="#" style="color:red">메인 홈</a>
    <br>
    <table border="1" width="600" height="500">
        <tr height="15%">
            <th><a href="cate_input.do" style="color: red; text-decoration: none">카테고리등록</a></th>
            <th><a href="cate_list.do" style="color: black; text-decoration: none">카테고리목록</a></th>
            <th><a href="prod_input.do" style="color: black; text-decoration: none">상품등록</a></th>
            <th><a href="prod_list.do" style="color: black; text-decoration: none">상품목록</a></th>
            <th><a href="index.jsp" style="color: black; text-decoration: none">쇼핑몰홈</a></th>
        </tr>
        <tr height="75%">
            <td width="100%" height="100%" colspan="5">
        