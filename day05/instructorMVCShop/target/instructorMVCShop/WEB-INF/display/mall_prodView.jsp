<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-07-24
  Time: AM 8:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="mall_top.jsp"%>
<script type="text/javascript">
  function goCart(){
    document.f.action="cartAdd.mall";
    document.f.submit();
  }
  function goOrder(){
    document.f.action="order.mall?mode=buynow";
    document.f.submit();
  }
</script>
<table width="99%" border="1">
  <tr class="m1">
    <td colspan="2" align="center">
      <b>[${getProd.pname}] 상품 정보</b>
    </td>
  </tr>
  <tr>
    <td align="center" class="m3">
      <img src="prodImage/${getProd.pimage}" width="200" height="200" border="0">
    </td>
    <td class="m3">
      <form name="f" method="post">
        상품번호 : ${getProd.pnum}<br>
        상품이름 : ${getProd.pname}<br>
        상품가격 : <font color="red">${getProd.price}</font>원<br>
        상품포인트 : <font color="red">[${getProd.point}]</font>point<br>
        상품갯수 : <input type="text" name="qty" size="3" value="1">개<br><br>
        <input type="hidden" name="pnum" value="${getProd.pnum}">
        <input type="hidden" name="select" value="${param.select}">
        <a href="javascript:goCart()">장바구니</a>
        <a href="javascript:goOrder()">즉시구매</a>
      </form>
    </td>
  </tr>
  <tr>
    <td colspan="2" align="left">
      <b>상품 상세 설명</b><br>
      ${getProd.pcontents}
    </td>
  </tr>
</table>
<%@ include file="mall_bottom.jsp"%>
