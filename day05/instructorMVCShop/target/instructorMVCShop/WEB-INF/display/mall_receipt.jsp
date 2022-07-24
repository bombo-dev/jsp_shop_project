<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-07-24
  Time: AM 11:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="mall_top.jsp"%>
<table width="90%" border="0">
    <tr>
        <th colspan="3" bgcolor="orange" style="text-align: center; color: blue; height:30px;">결제 내역서 보기</th>
    </tr>
    <tr style="background-color: lightgray; color: blue; font-weight: bold">
        <th width="50%">상품명</th>
        <th width="20%">수량</th>
        <th width="30%">금액</th>
    </tr>
    <c:if test="${empty prodBuy}">
        <c:set var="cartTotalPrice" value="0"/>
        <c:forEach var="bdto" items="${prodBuyList}">
            <tr>
                <td width="50%" style="text-align: center; color: blue;">${bdto.pname}</td>
                <td width="20%" style="text-align: right; color: blue;">${bdto.pqty}</td>
                <td width="30%" style="text-align: right; color: blue;">${bdto.price}</td>
            </tr>
            <c:set var="cartTotalPrice" value="${cartTotalPrice + (bdto.price * bdto.pqty)}"/>
        </c:forEach>
    </c:if>
    <c:if test="${not empty prodBuy}">
        <tr>
            <td width="50%" style="text-align: center; color: blue;">${prodBuy.pname}</td>
            <td width="20%" style="text-align: right; color: blue;">${prodBuy.pqty}</td>
            <td width="30%" style="text-align: right; color: blue;">${prodBuy.price}</td>
        </tr>
        <c:set var="cartTotalPrice" value="${prodBuy.price * prodBuy.pqty}"/>
    </c:if>
    <tr>
        <th colspan="3" style="background-color: lightgray">
            <font color="blue" style="font-weight: bold">결제하실 총액은:</font>
            <font color="red">${cartTotalPrice} 원</font>
        </th>
    </tr>

</table>
<%@ include file="mall_bottom.jsp"%>
