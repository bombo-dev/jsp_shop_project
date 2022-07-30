<%--
  Created by IntelliJ IDEA.
  User: munjong-un
  Date: 2022/07/31
  Time: 7:52 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<!-- member_input.jsp -->
<%@ include file="top.jsp"%>
<script type="text/javascript">
  function check(){
    if (f.id.value==""){
      alert("아이디를 입력해 주세요!!")
      f.id.focus()
      return false
    }
    if (f.passwd.value==""){
      alert("비밀번호를 입력해 주세요!!")
      f.passwd.focus()
      return false
    }
    return true
  }
</script>
<div align="center">
  <form name="f" action="member_input_ok.do"
        method="post" onsubmit="return check()">
    <b>회원가입</b>
    <table border="1" width="80%">
      <tr>
        <th width="20%" bgcolor="yellow">이름</th>
        <td><input type="text" name="name" value="${param.name}" readOnly></td>
      </tr>
      <tr>
        <th bgcolor="yellow">아이디</th>
        <td><input type="text" name="id"></td>
      </tr>
      <tr>
        <th bgcolor="yellow">비밀번호</th>
        <td><input type="password" name="passwd"></td>
      </tr>
      <tr>
        <th bgcolor="yellow">주민번호</th>
        <td><input type="text" name="ssn1" value="${param.ssn1}" readOnly>
          - <input type="password" name="ssn2" value="${param.ssn2}" readOnly></td>
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
      <tr>
        <td align="center" colspan="2" bgcolor="yellow">
          <input type="submit" value="회원가입">
          <input type="reset" value="다시입력">
        </td>
      </tr>
    </table>
  </form>
</div>
<%@ include file="bottom.jsp"%>
