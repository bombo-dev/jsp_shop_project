<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- updatePro.jsp -->
<%	request.setCharacterEncoding("EUC-KR"); %>
<jsp:useBean id="bdto" class="board.BoardDTO" />
<jsp:setProperty property="*" name="bdto" />
<jsp:useBean id="bdao" class="board.BoardDAO" />
<%
	if (bdto.getWriter()==null || bdto.getWriter().trim().equals("")){
		response.sendRedirect("index.jsp");
		return;
	}
	int res = bdao.updateBoard(bdto);
	if (res>0){%> 
	<script type="text/javascript">
		alert("�Խñۼ��� ����!! �Խñ۸���������� �̵��մϴ�.")
		location.href="list.jsp"
	</script>	
<%	}else if (res<0){%>
	<script type="text/javascript">
		alert("��й�ȣ�� Ʋ�Ƚ��ϴ�. �ٽ� �Է��� �ּ���")
		location.href="updateForm.jsp?num=<%=bdto.getNum()%>"
	</script>
<%	}else {%>
	<script type="text/javascript">
		alert("�Խñۼ��� ����!! �Խñۻ󼼺����������� �̵��մϴ�.")
		location.href="content.jsp?num=<%=bdto.getNum()%>"
	</script>	
<%	}%>	






