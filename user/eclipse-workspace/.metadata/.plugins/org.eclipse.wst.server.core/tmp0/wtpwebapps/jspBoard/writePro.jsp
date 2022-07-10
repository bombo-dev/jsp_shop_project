<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- writePro.jsp -->
<%	request.setCharacterEncoding("EUC-KR"); %>
<jsp:useBean id="bdto" class="board.BoardDTO" />
<jsp:setProperty property="*" name="bdto" />
<jsp:useBean id="bdao" class="board.BoardDAO" />
<%
	if (bdto.getWriter()==null || bdto.getWriter().trim().equals("")){
		response.sendRedirect("index.jsp");
		return;
	}
	bdto.setIp(request.getRemoteAddr());
	int res = bdao.insertBoard(bdto);
	if (res>0){%>
	<script type="text/javascript">
		alert("게시글등록 성공!! 게시글목록페이지로 이동합니다.")
		location.href="list.jsp"
	</script>	
<%	}else {%>
	<script type="text/javascript">
		alert("게시글등록 실패!! 게시글등록페이지로 이동합니다.")
		location.href="writeForm.jsp"
	</script>
<%	}%>







