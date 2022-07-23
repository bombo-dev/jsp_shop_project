<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-07-23
  Time: AM 11:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="top.jsp"%>
<form name="f" action="prod_list.do" method="post" enctype="multipart/form-data">
    <table class="outline" width="75%">
        <caption>상품상세보기</caption>
        <tr>
            <th width="15%" class="m2">카테고리</th>
            <td width="35%" align="center">${dto.pcategory_fk}></td>
            <th width="15%" class="m2">상품번호</th>
            <td width="35%" align="center">${dto.pnum}</td>
        </tr>
        <tr>
            <th width="15%" class="m2">상품명</th>
            <td width="35%" align="center">${dto.pname}</td>
            <th width="15%" class="m2">제조회사</th>
            <td width="35%" align="center">${dto.pcompany}</td>
        </tr>
        <tr>
            <th width="15%" class="m2">상품이미지</th>
            <td width="35%" align="center" colspan="3">
                <img src="${upPath}/${dto.pimage}" border="0" width="140" height="140">
            </td>
        </tr>
        <tr>
            <th width="15%" class="m2">상품수량</th>
            <td width="35%" align="center">${dto.pqty}</td>
            <th width="15%" class="m2">상품가격</th>
            <td width="35%" align="center">${dto.price}</td>
        </tr>
        <tr>
            <th width="15%" class="m2">상품스펙</th>
            <td width="35%" align="center">${dto.pspec}</td>
            <th width="15%" class="m2">상품포인트</th>
            <td width="35%" align="center">${dto.point}</td>
        </tr>
        <tr>
            <th width="15%" class="m2">상품소개</th>
            <td width="35%" align="center" colspan="3">
                <textarea name="pcontents" rows="5" cols="50" readOnly>${dto.pcontents}</textarea>
            </td>
        </tr>
        <tr>
            <td colspan="4" class="m1" align="center">
                <input type="submit" value="돌아가기">
            </td>
        </tr>
    </table>
</form>
<%@include file="bottom.jsp"%>
