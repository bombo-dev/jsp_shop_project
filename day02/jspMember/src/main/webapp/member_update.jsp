<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-07-10
  Time: PM 1:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="top.jsp"%>
<%
    request.setCharacterEncoding("utf-8");
    String no = request.getParameter("no");
%>
<script type="text/javascript">
    function check(){
        if (f.passwd.value==""){
            alert("비밀번호를 입력해주세요 !!")
            f.passwd.focus()
            return false
        }


        if (f.email.value==""){
            alert("이메일을 입력해주세요 !!")
            f.email.focus()
            return false
        }

        if (f.hp1.value=="" || f.hp2.value=="" || f.hp3.value==""){
            alert("전화번호를 입력해주세요 !!")
            f.hp1.focus()
            return false
        }
        return true
    }
</script>
<div align="center">
    <form name="f" action="member_update_ok.jsp" method="post" onsubmit="return check()">
        <table border="1" width="80%">
            <tr>
                <th bgcolor="yellow">비밀번호</th>
                <td><input type="password" name="passwd"></td>
            </tr>
            <tr>
                <th bgcolor="yellow">이메일</th>
                <td><input type="text" name="email"></td>
            </tr>
            <tr>
                <th bgcolor="yellow">전화번호</th>
                <td><input type="text" name="hp1" size="3" maxlength="3">
                    -<input type="text" name="hp2" size="4" maxlength="4">
                    -<input type="text" name="hp3" size="4" maxlength="4"></td>
            </tr>
            <input type="hidden" name="no" value="<%=no%>">
            <tr>
                <td align="center" colspan="2" bgcolor="yellow">
                    <input type="submit" value="수정완료">
                    <input type="reset" value="다시입력">
                </td>
            </tr>
        </table>
    </form>
</div>
<%@ include file="bottom.jsp"%>
