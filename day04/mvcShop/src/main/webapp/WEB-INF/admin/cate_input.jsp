<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-07-17
  Time: PM 2:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="top.jsp" %>
<div align="center">
    카테고리 등록
    <br>
    <form id="f" action="shop_admin_cate_list.do" method="post">
        <table border="1" width="300" height="100">
            <tr>
                <th bgcolor="yellow" width="30%">카테고리 코드</th>
                <td width="70%"><input type="text" name="code"></td>
            </tr>
            <tr>
                <th bgcolor="yellow" width="30%">카테고리 이름</th>
                <td width="70%"><input type="text" name="cname"></td>
            </tr>
            <tr>
                <th bgcolor="orange" colspan="2">
                    <input type="submit" value="등록">
                    <input type="button" value="취소"
                           onclick="window.location='shop_admin.do'">
                </th>
            </tr>
        </table>
    </form>
</div>
<%@include file="bottom.jsp" %>
