<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- member_delete.jsp -->
<jsp:useBean id="mbdao" class="member.MemberDAO" />
<%
	String no = request.getParameter("no");
	if (no==null || no.trim().equals("")){
		response.sendRedirect("index.jsp");
		return;
	}
	
	int res = mbdao.deleteMember(Integer.parseInt(no));
	if (res>0){%>
	<script type="text/javascript">
		alert("ȸ������ ����!! ȸ������������� �̵��մϴ�.")
		location.href="memberAll.jsp"
	</script>	
<%	}else {%>
	<script type="text/javascript">
		alert("ȸ������ ����!! ȸ������������� �̵��մϴ�.")
		location.href="memberAll.jsp"
	</script>
<%	}%>