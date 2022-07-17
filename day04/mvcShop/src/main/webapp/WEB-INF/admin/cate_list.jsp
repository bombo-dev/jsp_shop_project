<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-07-17
  Time: PM 2:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="top.jsp"%>
    <div align="center">
        <h3>카테고리 목록</h3>
        <br>
        <table border="1" width="600">
            <tr>
                <th bgcolor="yellow" width="15%">번호</th>
                <th bgcolor="yellow" width="30%">카테고리 코드</th>
                <th bgcolor="yellow" width="40%">카테고리 명</th>
                <th bgcolor="yellow" width="15%">삭제</th>
            </tr>
            <c:forEach var="dto" items="${CategoryList}">
                <tr>
                    <td>${dto.cnum}</td>
                    <td>${dto.code}</td>
                    <td>${dto.cname}</td>
                    <td><a href="shop_admin_cate_delete.do">삭제</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
<%@include file="bottom.jsp"%>
