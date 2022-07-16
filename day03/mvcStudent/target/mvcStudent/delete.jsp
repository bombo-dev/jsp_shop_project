<%@ page import="Student.StudentDAO" %>
<%@ page import="Student.StudentDTO" %><%--
  Created by IntelliJ IDEA.
  User: munjong-un
  Date: 2022/07/09
  Time: 11:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>학생 정보 삭제</title>
</head>

<body>
<%
    StudentDTO stdto = request.setAttribute();
    if (stdto.getId()==null || stdto.getId().trim().equals("")) { %>
<script type="text/javascript">
    alert("아이디를 모두 입력해 주세요!!")
    history.back()
</script>
<%		return;
}
    StudentDAO stdao = new StudentDAO();
    int res = stdao.delete(stdto);
    if (res != 0){%>
<script type="text/javascript">
    alert("학생삭제 성공!! 학생목록페이지로 이동합니다.")
    location.href="list.jsp"
</script>
<%	}else {%>
<script type="text/javascript">
    alert("학생삭제 실패!! 학생관리페이지로 이동합니다.")
    location.href="student.jsp"
</script>
<%	}%>
</body>
</html>
