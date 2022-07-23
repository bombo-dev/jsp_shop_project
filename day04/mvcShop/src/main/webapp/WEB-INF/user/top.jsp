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
    <title>쇼핑몰홈</title>
</head>
<body>
<table border="1" align="center" width="770">
    <tr height="50">
        <td colspan="2" align="center">
            <a href="index.mall">HOME</a> |
            <a href="adminShop.mall">관리자홈</a> |
            <a href="displayShop.mall">쇼핑몰홈</a> |
            <a href="">장바구니</a> |
            <a href="">회사소개</a>
        </td>
    </tr>
    <tr height="400">
        <td width="20%" align="center" valign="top">
            tree/view
            <table width="99%" align="center" border="1">
                <c:forEach var="cdto" items="${categoryList}">
                    <tr>
                        <td>
                            <a href="cgProdList.do?code=${cdto.code}&cname=${cdto.cname}">
                                    ${cdto.cname}[${cdto.code}]
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </td>
        <td align="center">
        