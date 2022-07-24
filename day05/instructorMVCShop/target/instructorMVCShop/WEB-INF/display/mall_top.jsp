<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-07-24
  Time: AM 8:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
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
        <c:forEach var="cdto" items="${listCate}">
          <tr>
            <td>
              <a href="cgProdList.mall?code=${cdto.code}">
                  ${cdto.cname}[${cdto.code}]
              </a>
            </td>
          </tr>
        </c:forEach>
      </table>
    </td>
    <form name="cg" method="post">
      <input type="hidden" name="code">
      <input type="hidden" name="cname">
    </form>
    <td align="center">