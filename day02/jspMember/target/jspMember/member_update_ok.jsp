<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-07-10
  Time: PM 1:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="top.jsp"%>
<% request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="mbdao" class="member.MemberDAO"/>

<%
        String passwd = request.getParameter("passwd");
        String email = request.getParameter("email");
        String hp1 = request.getParameter("hp1");
        String hp2 = request.getParameter("hp2");
        String hp3 = request.getParameter("hp3");
        String no = request.getParameter("no");
        int res = mbdao.updateMember(passwd, email, hp1, hp2, hp3, Integer.parseInt(no));
    String msg = null, url = null;
    if (res > 0) {
        msg = "회원수정성공!! 회원목록페이지로 이동합니다.";
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
