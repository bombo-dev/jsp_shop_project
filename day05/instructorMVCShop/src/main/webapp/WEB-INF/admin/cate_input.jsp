<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-07-24
  Time: AM 8:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="top.jsp" %>
<form name="f" action="cate_input_ok.mall" method="post">
    <table border="1" width="500" height="150">
        <caption>카테고리등록</caption>
        <tr>
            <th>카테고리코드</th>
            <td><input type="text" name="code"></td>
        </tr>
        <tr>
            <th>카테고리이름</th>
            <td><input type="text" name="cname"></td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="등록">
                <input type="reset" value="취소">
            </td>
        </tr>
    </table>
</form>
<%@ include file="bottom.jsp" %>
