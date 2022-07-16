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
		alert("게시글수정 성공!! 게시글목록페이지로 이동합니다.")
		location.href="list.jsp"
	</script>	
<%	}else if (res<0){%>
	<script type="text/javascript">
		alert("비밀번호가 틀렸습니다. 다시 입력해 주세요")
		location.href="updateForm.jsp?num=<%=bdto.getNum()%>"
	</script>
<%	}else {%>
	<script type="text/javascript">
		alert("게시글수정 실패!! 게시글상세보기페이지로 이동합니다.")
		location.href="content.jsp?num=<%=bdto.getNum()%>"
	</script>	
<%	}%>	






