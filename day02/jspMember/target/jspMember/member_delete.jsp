<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-07-10
  Time: PM 12:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="top.jsp" %>
<jsp:useBean id="mbdao" class="member.MemberDAO"/>
<%
    String no = request.getParameter("no");
    if (no == null || no.trim().equals("")) {
        response.sendRedirect("index.jsp");
        return;
    }

    int res = mbdao.deleteMember(Integer.parseInt(no));
    String msg = null, url = null;
    if (res > 0) {
        msg = "회원삭제성공!! 초기페이지로 이동합니다.";
        url = "memberAll.jsp";
    } else {
        msg = "회원삭제실패!! 회원목록페이지로 이동합니다.";
        url = "memberAll.jsp";
    }
%>
<script type="text/javascript">
    alert("<%=msg%>")
    location.href = "<%=url%>"
</script>
<%@include file="bottom.jsp" %>

