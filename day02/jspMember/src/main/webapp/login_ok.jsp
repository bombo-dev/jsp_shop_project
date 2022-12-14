<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="member.*"%>
<!-- login_ok.jsp -->
<jsp:useBean id="loginCheck" class="member.LoginCheck"/>
<jsp:setProperty property="*" name="loginCheck"/>
<%
		if (loginCheck.getId() == null || loginCheck.getId().trim().equals("")){
			response.sendRedirect("login.jsp");
			return;
		}
		String saveId = request.getParameter("saveId");
		//체크가 되어 있으면 on, 체크가 안되어 있으면 null
		Cookie ck = new Cookie("saveId", loginCheck.getId());

		int res = loginCheck.checkLogin();
		String msg = null, url = null;
		switch(res){
		case LoginCheck.OK :
			if (saveId != null){
				ck.setMaxAge(24*60*60);
			}else {
				ck.setMaxAge(0);		//삭제와 같은 효과가 난다
			}
			response.addCookie(ck);
			session.setAttribute("mbId", loginCheck.getId());
			msg = "로그인이 되었습니다.";
			url = "index.jsp";
			break;
		case LoginCheck.NOT_ID :
			msg = "없는 아이디 입니다. 다시 로그인을 해 주세요";
			url = "login.jsp";
			break;
		case LoginCheck.NOT_PWD :
			msg = "비밀번호가 틀렸습니다. 다시 입력해 주세요";
			url = "login.jsp";
			break;
		case LoginCheck.ERROR :
			msg = "DB서버 오류 발생!! 관리자에게 문의해 주세요";
			url = "index.jsp";
		}
%>
<script type="text/javascript">
	alert("<%=msg%>")
	location.href="<%=url%>"
</script>









