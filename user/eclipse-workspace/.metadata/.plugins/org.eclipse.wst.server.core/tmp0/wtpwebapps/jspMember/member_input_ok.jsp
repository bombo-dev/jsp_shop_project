<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- member_input_ok.jsp -->
<%
	request.setCharacterEncoding("EUC-KR");
%>
<jsp:useBean id="mbdto" class="member.MemberDTO" />
<jsp:setProperty property="*" name="mbdto"/>
<jsp:useBean id="mbdao" class="member.MemberDAO" />
<%
	if (mbdto.getName() == null || mbdto.getName().trim().equals("")){
		response.sendRedirect("index.jsp");
		return;
	}

	int res = mbdao.insertMember(mbdto);
	if (res>0){%>
	<script type="text/javascript">
		alert("ȸ����� ����!! ȸ�������������� �̵��մϴ�.")
		location.href="index.jsp"
	</script>	
<%	}else {%>
	<script type="text/javascript">
		alert("ȸ����� ����!! ȸ������������� �̵��մϴ�.")
		location.href="member_input.jsp"
	</script>
<%	}%>

