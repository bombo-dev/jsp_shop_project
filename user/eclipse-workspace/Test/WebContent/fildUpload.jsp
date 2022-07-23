<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-07-23
  Time: AM 9:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>파일 업로드</title>
</head>
<body>
    <div align="center">
        <hr color="green" width="300">

        <h2>파일 업로드 테스트</h2>

        <hr color="green" width="300">
        <form name="f" action="fildUpload_ok.jsp" method="post" enctype="multipart/form-data">
            <table border="1" width="500">
                <tr>
                    <th>올린이</th>
                    <td><input type="text" name="name"></td>
                </tr>
                <tr>
                    <th>파일명</th>
                    <td><input type="file" name="filename"></td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="업로드">
                        <input type="reset" value="취소">
                    </td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>
