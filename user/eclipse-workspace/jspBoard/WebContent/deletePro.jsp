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
		alert("게시글삭제 성공!! 게시글목록페이지로 이동합니다.")
		location.href="list.jsp"
	</script>	
<%	}else if (res<0){%>
	<script type="text/javascript">
		alert("비밀번호가 틀렸습니다. 다시 입력해 주세요")
		location.href="deleteForm.jsp?num=<%=num%>"
	</script>
<%	}else {%>
	<script type="text/javascript">
		alert("게시글삭제 실패!! 게시글상세보기페이지로 이동합니다.")
		location.href="content.jsp?num=<%=num%>"
	</script>	
<%	}%>

