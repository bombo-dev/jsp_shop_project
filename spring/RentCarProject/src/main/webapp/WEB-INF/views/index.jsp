<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>       
<!-- index.jsp -->
<html>
<head>
	<title>��Ʈī������Ʈ</title>
	<script type="text/javascript">
		function checkMember(){
			window.open("memberSsn.do", "", "width=640, height=400")
		}	
	</script>
</head>
<body>
	<table border="0" width="100%" height="100%">
		<tr>		
			<td align="right">
		<c:if test="${empty member}">			
			<a href="login.do">�α���</a> | 
			<a href="javascript:checkMember()">ȸ������</a>
		</c:if>
		<c:if test="${not empty member}">
			<a href="logout.do">�α׾ƿ�</a>
			<a href="member_update.do">����������</a>
		</c:if>	
			</td>
		</tr>
		<tr>
			<td align="center">�����ϱ� | ����Ȯ�� | �����ϱ� | �����Խ��� | 
			<a href="notice_board.do">��������</a> | ȸ��Ұ�</td>
		</tr>
		<tr height="80%">
			<td>
				<img src="resources/img/rentcar.png" width="100%" height="100%">
			</td>
		</tr>
		<tr>
			<td align="center">
				KG ����Ƽ��ũ 7-8�� ������Ʈ��
			</td>
		</tr>
	</table>
</body>
</html>