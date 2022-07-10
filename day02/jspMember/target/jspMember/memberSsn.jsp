<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-07-10
  Time: AM 9:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="top.jsp"%>
<div align="center">
  <hr color="green" width="300">
  <h2>회원가입 유무</h2>
  <hr color="green" width="300">
  <form name="f" action="memberCheck.jsp" method="post">
    <table border="1" width="500">
      <tr>
        <th width="20%">이름</th>
        <td><input type="text" name="name"></td>
      </tr>
      <tr>
        <th width="20%">주민번호</th>
        <td>
          <input type="text" name="ssn1" maxlength="6">-<input type="password" name="ssn2" maxlength="7"></td>
      </tr>
      <tr>
        <td colspan="2" align="center">
          <input type="submit" value="조회">
          <input type="reset" value="취소">
        </td>
      </tr>
    </table>
  </form>
</div>
<%@include file="bottom.jsp"%>
