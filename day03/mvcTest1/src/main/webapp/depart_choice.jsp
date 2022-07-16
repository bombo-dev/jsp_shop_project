<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-07-16
  Time: PM 12:38
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>학과선택</title>
</head>
<body>
<!-- 1번 -->
    <h1 align="center">학과 선택 페이지</h1>
    <form name="f" action="depart.do" method="post">
        학과선택:
        <select name="depart" size="1">
            <option value="c">C</option>
            <option value="java">JAVA</option>
            <option value="python">파이썬</option>
            <option value="go">GO</option>
        </select>
        <input type="submit" value="전송">
    </form>
</body>
</html>
