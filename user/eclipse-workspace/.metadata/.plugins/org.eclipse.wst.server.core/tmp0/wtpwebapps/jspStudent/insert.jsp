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
		alert("아이디, 학생명, 학급명을 모두 입력해 주세요!!")
		history.back()
	</script>	
<%		return;
	}
	int res = stdao.insertStudent(stdto);
	if (res>0){%>
	<script type="text/javascript">
		alert("학생등록 성공!! 학생목록페이지로 이동합니다.")
		location.href="list.jsp"
	</script>	
<%	}else {%>
	<script type="text/javascript">
		alert("학생등록 실패!! 학생관리페이지로 이동합니다.")
		location.href="student.jsp"
	</script>
<%	}%>






