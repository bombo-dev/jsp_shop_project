<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- deletePro.jsp -->
<jsp:useBean id="bdao" class="board.BoardDAO" />
<%
	String num = request.getParameter("num");
	String passwd = request.getParameter("passwd");
	if (num == null || num.trim().equals("") || 
			passwd==null || passwd.trim().equals("")){
		response.sendRedirect("index.jsp");
		return;
	}	
	int res = bdao.deleteBoard(Integer.parseInt(num), passwd);
	if (res>0){%> 
	<script type="text/javascript">
		alert("�Խñۻ��� ����!! �Խñ۸���������� �̵��մϴ�.")
		location.href="list.jsp"
	</script>	
<%	}else if (res<0){%>
	<script type="text/javascript">
		alert("��й�ȣ�� Ʋ�Ƚ��ϴ�. �ٽ� �Է��� �ּ���")
		location.href="deleteForm.jsp?num=<%=num%>"
	</script>
<%	}else {%>
	<script type="text/javascript">
		alert("�Խñۻ��� ����!! �Խñۻ󼼺����������� �̵��մϴ�.")
		location.href="content.jsp?num=<%=num%>"
	</script>	
<%	}%>

