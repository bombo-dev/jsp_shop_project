<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-07-23
  Time: PM 4:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="top.jsp"%>
<table width="99%" border="0" class="outline">
    <tr class="m1">
        <td colspan="2" align="center">
            <b>[${dto.pname}] 상품 정보</b>
        </td>
    </tr>
    <tr>
        <td align="center" class="m3">
            <img src="prodImage/${dto.pimage}" width="200" height="200" border="0">
        </td>
        <td class="m3">
            <form name="f" method="post">
                상품번호 : ${dto.pnum}<br>
                상품이름 : ${dto.pname}<br>
                상품가격 : <font color="red">${dto.price}</font>원<br>
                상품포인트 : <font color="red">[${dto.point}]</font>point<br>
                상품갯수 : <input type="text" name="qty" size="3" value="1">개<br><br>
                <input type="hidden" name="pnum" value="${dto.pnum}">
                <input type="hidden" name="select" value="${param.select}">
                <a href="javascript:goCart()">장바구니</a>
                <a href="javascript:goOrder()">즉시구매</a>
            </form>
        </td>
    </tr>
    <tr>
        <td colspan="2" align="left">
            <b>상품 상세 설명</b><br>
            ${dto.pcontents}
        </td>
    </tr>
</table>

<%@ include file="bottom.jsp"%>
