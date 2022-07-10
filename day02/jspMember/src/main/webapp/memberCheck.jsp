<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-07-10
  Time: AM 10:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> 회원 조회 </title>
</head>
<!-- member_check.jsp -->
<jsp:useBean id="mbdao" class="member.MemberDAO" />
    <%
	request.setCharacterEncoding("utf-8");
	String name = request.getParameter("name");
	String ssn1 = request.getParameter("ssn1");
	String ssn2 = request.getParameter("ssn2");
	if (name==null || ssn1==null || ssn2==null ||
			name.trim().equals("") || ssn1.trim().equals("") || ssn2.trim().equals("")){
		response.sendRedirect("index.jsp");
		return;
	}

	boolean isMember = mbdao.checkMember(name, ssn1, ssn2);
	if (isMember){%>
<script type="text/javascript">
    alert("이미 회원이십니다. 로그인을 해 주세요!!")
    location.href="index.jsp"
</script>
    <%	}else {%>
<form name="f" action="member_input.jsp" method="post">
    <input type="hidden" name="name" value="<%=name%>"/>
    <input type="hidden" name="ssn1" value="<%=ssn1%>"/>
    <input type="hidden" name="ssn2" value="<%=ssn2%>"/>
</form>
<script type="text/javascript">
    alert("회원등록페이지로 이동합니다.")
    document.f.submit()
</script>
    <%	}%>

