<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- insert.jsp -->
<%
	request.setCharacterEncoding("EUC-KR");
%>
<jsp:useBean id="stdto" class="student.StudentDTO"/>
<jsp:setProperty property="*" name="stdto" />
<jsp:useBean id="stdao" class="student.StudentDAO"/>
<%
	if (stdto.getId()==null || stdto.getId().trim().equals("") || 
		stdto.getName()==null || stdto.getName().trim().equals("") ||
		stdto.getCname()==null || stdto.getCname().trim().equals("")){%>
	<script type="text/javascript">
		alert("���̵�, �л���, �б޸��� ��� �Է��� �ּ���!!")
		history.back()
	</script>	
<%		return;
	}
	int res = stdao.insertStudent(stdto);
	if (res>0){%>
	<script type="text/javascript">
		alert("�л���� ����!! �л������������ �̵��մϴ�.")
		location.href="list.jsp"
	</script>	
<%	}else {%>
	<script type="text/javascript">
		alert("�л���� ����!! �л������������� �̵��մϴ�.")
		location.href="student.jsp"
	</script>
<%	}%>






