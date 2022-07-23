<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-07-23
  Time: PM 1:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="top.jsp" %>

<h3>Welcome to My Mall</h3>
<c:if test="${empty HIT}">
    <b>HIT상품이 없습니다</b><br>
</c:if>
<c:if test="${not empty HIT}">
    <hr color="green" width="80%">
    <font color="red" size="3">HIT</font>
    <hr color="green" width="80%">
    <br>
</c:if>
<table width="100%" border="0" align="center">
    <tr>
        <c:set var="count" value="0"/>
        <c:forEach var="dto" items="${HIT}">
        <c:set var="count" value="${count+1}"/>
        <td align="center">
            <a href="prodView.do?pnum=${dto.pnum}&select=HIT">
                <img src="prodImage/${dto.pimage}" width="80" height="60" border="0">
            </a>
            <br>
                ${dto.pname}<br>
            <font color="red">${dto.price}</font>원<br>
            <font color="blue">[${dto.point}]</font>point
        </td>
        <c:if test="${count%3==0}">
    </tr><tr>
    </c:if>
    </c:forEach>
</tr>
</table>
<c:if test="${empty NEW}">
    <b>NEW상품이 없습니다</b><br>
</c:if>
<c:if test="${not empty NEW}">
    <hr color="green" width="80%">
    <font color="red" size="3">NEW</font>
    <hr color="green" width="80%">
    <br>
</c:if>
<table width="100%" border="0" align="center">
    <tr>
        <c:set var="count" value="0"/>
        <c:forEach var="dto" items="${NEW}">
        <c:set var="count" value="${count+1}"/>
        <td align="center">
            <a href="prodView.do?pnum=${dto.pnum}&select=NEW">
                <img src="prodImage/${dto.pimage}" width="80" height="60" border="0">
            </a>
            <br>
                ${dto.pname}<br>
            <font color="red">${dto.price}</font>원<br>
            <font color="blue">[${dto.point}]</font>point
        </td>
        <c:if test="${count%3==0}">
    </tr><tr>
    </c:if>
    </c:forEach>
</tr>
</table>
<c:if test="${empty BEST}">
    <b>BEST상품이 없습니다</b><br>
</c:if>
<c:if test="${not empty BEST}">
    <hr color="green" width="80%">
    <font color="red" size="3">BEST</font>
    <hr color="green" width="80%">
    <br>
</c:if>
<table width="100%" border="0" align="center">
    <tr>
        <c:set var="count" value="0"/>
        <c:forEach var="dto" items="${BEST}">
        <c:set var="count" value="${count+1}"/>
        <td align="center">
            <a href="prodView.do?pnum=${dto.pnum}&select=BEST">
                <img src="prodImage/${dto.pimage}" width="80" height="60" border="0">
            </a>
            <br>
                ${dto.pname}<br>
            <font color="red">${dto.price}</font>원<br>
            <font color="blue">[${dto.point}]</font>point
        </td>
        <c:if test="${count%3==0}">
    </tr><tr>
    </c:if>
    </c:forEach>
</tr>
</table>


<%@ include file="bottom.jsp" %>
