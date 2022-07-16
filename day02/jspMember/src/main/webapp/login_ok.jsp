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
		//üũ�� �Ǿ� ������ on, üũ�� �ȵǾ� ������ null
		Cookie ck = new Cookie("saveId", loginCheck.getId());

		int res = loginCheck.checkLogin();
		String msg = null, url = null;
		switch(res){
		case LoginCheck.OK :
			if (saveId != null){
				ck.setMaxAge(24*60*60);
			}else {
				ck.setMaxAge(0);		//������ ���� ȿ���� ����
			}
			response.addCookie(ck);
			session.setAttribute("mbId", loginCheck.getId());
			msg = "�α����� �Ǿ����ϴ�.";
			url = "index.jsp";
			break;
		case LoginCheck.NOT_ID :
			msg = "���� ���̵� �Դϴ�. �ٽ� �α����� �� �ּ���";
			url = "login.jsp";
			break;
		case LoginCheck.NOT_PWD :
			msg = "��й�ȣ�� Ʋ�Ƚ��ϴ�. �ٽ� �Է��� �ּ���";
			url = "login.jsp";
			break;
		case LoginCheck.ERROR :
			msg = "DB���� ���� �߻�!! �����ڿ��� ������ �ּ���";
			url = "index.jsp";
		}
%>
<script type="text/javascript">
	alert("<%=msg%>")
	location.href="<%=url%>"
</script>









