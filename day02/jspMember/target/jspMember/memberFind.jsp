<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-07-10
  Time: PM 1:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="top.jsp"%>

    <form id="find" action="member_find_ok.jsp" method="post">
        <select name="choice" form="find">
            <option value="id">아이디</option>
            <option value="name">이름</option>
        </select>
        <input type="text" name="choice">
        <input type="submit" value="찾기">
    </form>
<%@ include file="bottom.jsp"%>
