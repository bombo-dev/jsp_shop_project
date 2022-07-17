<%@ page import="board.DTO.BoardDTO" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-07-17
  Time: AM 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- updateForm.jsp -->

<html>
<head>
    <title>글수정</title>
    <script type="text/javascript">
        function check(){
            if (f.writer.value==""){
                alert("이름을 입력해 주세요!!")
                f.writer.focus()
                return false
            }
            if (f.subject.value==""){
                alert("제목을 입력해 주세요!!")
                f.subject.focus()
                return false
            }
            if (f.content.value==""){
                alert("내용을 입력해 주세요!!")
                f.content.focus()
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
</head>
<body>
<div align="center">
    <form name="f" action="board_updatePro.do"
          method="post" onsubmit="return check()">
        <input type="hidden" name="num" value="${update.num}"/>
        <table border="1" width="600">
            <tr bgcolor="yellow">
                <td colspan="2" align="center">글수정</td>
            </tr>
            <tr>
                <th bgcolor="yellow" width="20%">이 름</th>
                <td><input type="text" name="writer" value="${update.writer}" readOnly></td>
            </tr>
            <tr>
                <th bgcolor="yellow">제 목</th>
                <td><input type="text" name="subject" size="60" value="${update.subject}"></td>
            </tr>
            <tr>
                <th bgcolor="yellow">Email</th>
                <td><input type="text" name="email" size="60" value="${update.email}"></td>
            </tr>
            <tr>
                <th bgcolor="yellow">내 용</th>
                <td><textarea name="content" rows="13" cols="60">${update.content}</textarea></td>
            </tr>
            <tr>
                <th bgcolor="yellow">비밀번호</th>
                <td><input type="password" name="passwd"></td>
            </tr>
            <tr bgcolor="yellow">
                <td colspan="2" align="center">
                    <input type="submit" value="글수정">
                    <input type="reset" value="다시작성">
                    <input type="button" value="목록보기"
                           onclick="window.location='board_list.do'">
                </td>
            </tr>
        </table>

    </form>
</div>
</body>
</html>
