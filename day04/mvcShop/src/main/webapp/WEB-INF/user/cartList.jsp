<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-07-24
  Time: AM 9:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="top.jsp"%>
<form name ="f" action ="ProdPayment.do">
    <table border="1">
        <tr>
            <th bgcolor="orange" align="center" colspan="6">
                장바구니 보기
            </th>
        </tr>
        <tr>
            <th>번호</th>
            <th>상품명</th>
            <th>수량</th>
            <th>단가</th>
            <th>금액</th>
            <th>삭제</th>
        </tr>
        <c:set var="totalPrice" value="0"/>
        <c:set var="totalPoint" value="0"/>
        <c:forEach var="pdto" items="${basketList}">
            <tr>
                <td>${pdto.pnum}</td>
                <td>
                    <img src="prodImage/${pdto.pimage}" style="width: 30px; height: 30px;">
                    <p>${pdto.pname}</p>
                </td>
                <td>
                    <input type="text" name="pqty" value="${pdto.pqty}">개
                    <input type="button" name="modifyPqty" value="수정" onclick="window.location='ProdShoppingBasketEdit.do'">
                </td>
                <td>
                    <p style="color:blue;">${pdto.price} 원</p>
                    <p style="color:blue;">[${pdto.point}] point</p>
                </td>
                <td>
                    <p style="color:red;">${pdto.price} 원</p>
                    <p style="color:red;">[${pdto.point}] point</p>
                </td>
                <td>
                    <a href="ProdShoppingBasketDelete.do">삭제</a>
                </td>
            </tr>
            <c:set var="totalPrice" value="${totalPrice + (pdto.price * pdto.pqty)}"/>
            <c:set var="totalPoint" value="${totalPoint + (pdto.price * pdto.pqty)}"/>
        </c:forEach>
        <tr>
            <th colspan="4" bgcolor="#d3d3d3" height="40">
                <p style="color:blue; text-align: left">장바구니 총액:</p><p style="color:red;">${totalPrice}</p><br>
                <p style="color:green; text-align: left; font-weight: bold;">총 적립 포인트: [${totalPoint}] point</p>
            </th>
            <td colspan="2">
                <a href="ProdPayment.do">[주문하기]</a>
                <a href="mall.do">[계속쇼핑]</a>
            </td>
        </tr>
    </table>
</form>
<%@ include file="bottom.jsp"%>
