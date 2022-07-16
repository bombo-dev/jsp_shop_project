<%--
  Created by IntelliJ IDEA.
  User: munjong-un
  Date: 2022/07/14
  Time: 1:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>글쓰기</title>
    <script>
        function check() {
            if (f.writer.value==""){
                alert("이름을 입력해주세요.")
                f.writer.focus()
                return false
            }
            if (f.subject.value==""){
                alert("제목을 입력해주세요.")
                f.subject.focus()
                return false
            }
            if (f.content.value==""){
                alert("내용을 입력해주세요.")
                f.content.focus()
                return false
            }
            if (f.passwd.value==""){
                alert("비밀번호를 입력해주세요.")
                f.passwd.focus()
                return false
            }
            return true
        }
    </script>
</head>
<body>
    <div align="center">
        <form id="f" action="writePro.jsp" method="post" onsubmit="return check()">
            <table border="1" width="600">
                <tr bgcolor="yellow">
                    <td colspan="2" align="center">글쓰기</td>
                </tr>
                <tr>
                    <th bgcolor="yellow" width="20%">작 성 자</th>
                    <td><input type="text" name="writer"></td>
                </tr>
                <tr>
                    <th bgcolor="yellow">제 목</th>
                    <td><input type="text" name="subject" size="60"></td>
                </tr>
                <tr>
                    <th bgcolor="yellow">Email</th>
                    <td><input type="text" name="email" size="60"></td>
                </tr>
                <tr>
                    <th bgcolor="yellow">내 용</th>
                    <td><textarea name="content" rows="13" cols="60" style="overflow: auto"></textarea></td>
                </tr>
                <tr>
                    <th bgcolor="yellow">비밀번호</th>
                    <td><input type="password" name="passwd"></td>
                </tr>
                <tr bgcolor="yellow">
                    <td colspan="2" align="center">
                        <input type="submit" value="글쓰기">
                        <input type="reset" value="다시작성">
                        <input type="button" value="목록보기"
                               onclick="window.location='list.jsp'">
                    </td>
                </tr>
            </table>

        </form>
    </div>
</body>
</html>
