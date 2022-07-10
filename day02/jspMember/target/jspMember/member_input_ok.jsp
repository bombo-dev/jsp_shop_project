<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-07-10
  Time: AM 11:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="top.jsp"%>
<% request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="mbdto" class="member.MemberDTO"/>
<jsp:setProperty name="mbdto" property="*" />
<jsp:useBean id="mbdao" class="member.MemberDAO"/>

<%

%>


<%
    int row = mbdao.insertMember(mbdto);
    if(row != 0) { %>
    <script type="text/javascript">
        alert("회원가입이 완료되었습니다.");
        location.href="index.jsp"
    </script>

    <%} else { %>
<script type="text/javascript">
    alert("회원가입이 실패하였습니다.");
    location.href="index.jsp"
</script>
<% } %>
<%@include file="bottom.jsp"%>
