<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-07-24
  Time: AM 10:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="mall_top.jsp" %>
<c:if test="${empty cart}">
  <script type="text/javascript">
    alert("장바구니에 물품이 없습니다.");
    location.href="displayShop.mall";
  </script>
</c:if>
<c:if test="${not empty cart}">
  <table border="1">
    <tr>
      <th colspan="6">
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
    <c:set var="cartTotalPrice" value="0"/>
    <c:set var="cartTotalPoint" value="0"/>
    <c:forEach var="dto" items="${cart}">
      <tr>
        <td>${dto.pnum}</td>
        <td>
          <img src="prodImage/${dto.pimage}" width="40" height="40"><br>
            ${dto.pname}
        </td>
        <td>
          <form name="f" method="post" action="cartEdit.mall">
            <input type="text" name="qty" value="${dto.pqty}" size="3"> 개
            <input type="hidden" name="pnum" value="${dto.pnum}">
            <br><input type="submit" value="수정">
          </form>
        </td>
        <td>
            ${dto.price}원<br>
          [${dto.point}] point
        </td>
        <td>
            ${dto.price * dto.pqty}원<br>
          [${dto.point * dto.pqty}] point
          <c:set var="cartTotalPrice" value="${cartTotalPrice + (dto.price*dto.pqty)}"/>
          <c:set var="cartTotalPoint" value="${cartTotalPoint + (dto.point*dto.pqty)}"/>
        </td>
        <td>
          <a href="cartDel.mall?pnum=${dto.pnum}">삭제</a>
        </td>
      </tr>
      <tr class="m1">
        <td colspan="4">
          <b>장바구니총액 : </b>
          <font color="red">${cartTotalPrice}원</font><br>
          <font color="green">총 적립 포인트 : ${cartTotalPoint}point</font>
        </td>
        <td colspan="2">
          [<a href="order.mall">주문하기</a>]
          [<a href="displayShop.mall">계속쇼핑</a>]
        </td>
      </tr>
    </c:forEach>
  </table>
</c:if>
<%@ include file="mall_bottom.jsp" %>
