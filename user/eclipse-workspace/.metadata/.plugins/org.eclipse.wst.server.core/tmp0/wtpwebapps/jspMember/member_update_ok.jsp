<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- member_update_ok.jsp -->
<%	request.setCharacterEncoding("EUC-KR"); %>
<jsp:useBean id="mbdto" class="member.MemberDTO"/>
<jsp:setProperty property="*" name="mbdto" />
<jsp:useBean id="mbdao" class="member.MemberDAO" />
<%
	if (mbdto.getName() == null || mbdto.getName().trim().equals("")){
		response.sendRedirect("index.jsp");
		return;
	}

	int res = mbdao.updateMember(mbdto);
	if (res>0){%> 
	<script type="text/javascript">
		alert("회원수정 성공!! 회원목록페이지로 이동합니다.")
		location.href="memberAll.jsp"
	</script>	
<%	}else {%>
	<script type="text/javascript">
		alert("회원수정 실패!! 회원목록페이지로 이동합니다.")
		location.href="memberAll.jsp"
	</script>
<%	}%>