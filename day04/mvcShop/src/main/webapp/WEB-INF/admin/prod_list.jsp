<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-07-23
  Time: AM 11:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="top.jsp"%>
<script type="text/javascript">
  function checkDel(pnum, pimage){
    var isDel = window.confirm("정말로 삭제하시겠습니까?");
    if (isDel){
      location.href="prod_delete.do?pnum="+pnum + "&pimage="+pimage;
    }
  }
</script>
<table border="1" width="99%">
  <caption>상품목록</caption>
  <tr class="m2">
    <th>번호</th>
    <th>상품코드</th>
    <th>상품명</th>
    <th>이미지</th>
    <th>가격</th>
    <th>제조사</th>
    <th>수량</th>
    <th>수정|삭제</th>
  </tr>
  <c:if test="${empty listProd}">
    <tr>
      <td colspan="8" align="center">
        등록된 상품이 없습니다.
      </td>
    </tr>
  </c:if>
  <c:forEach var="dto" items="${listProd}">
    <tr>
      <td>${dto.pnum}</td>
      <td>${dto.pcategory_fk}</td>
      <td>${dto.pname}</td>
      <td>
        <a href="prod_view.do?pnum=${dto.pnum}">
          <img src="${upPath}/${dto.pimage}" border="0" width="40" height="40">
        </a>
      </td>
      <td>${dto.price}</td>
      <td>${dto.pcompany}</td>
      <td>${dto.pqty}</td>
      <td>
        <a href="prod_update.do?pnum=${dto.pnum}">수정</a> |
        <a href="javascript:checkDel('${dto.pnum}','${dto.pimage}');">삭제</a>
      </td>
    </tr>
  </c:forEach>
</table>
