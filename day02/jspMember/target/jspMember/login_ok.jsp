<%@ page import="member.MemberDTO" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-07-16
  Time: AM 10:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% request.setCharacterEncoding("utf-8");
String id = request.getParameter("id");
String pwd = request.getParameter("pwd");

%>
<jsp:useBean id="mdto" class="member.MemberDTO"/>
<jsp:setProperty name="mdto" property="*"/>
<jsp:useBean id="mdao" class="member.MemberDAO"/>

<%
    MemberDTO dto = mdao.loginMember(id, pwd);
    if(dto == null) { %>
    <script>
        alert("아이디 혹은 비밀번호가 틀렸습니다.")
    </script>
    <% } else { %>
    <script>
        alert("로그인에 성공하셨습니다. 메인페이지로 이동합니다.")
        location.href = "index.jsp"
    </script>
<%
    request.setAttribute("login", dto);
    }
%>



