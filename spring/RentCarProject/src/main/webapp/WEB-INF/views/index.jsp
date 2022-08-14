<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>       
<!-- index.jsp -->
<html>
<head>
	<title>렌트카프로젝트</title>
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
			<a href="login.do">로그인</a> | 
			<a href="javascript:checkMember()">회원가입</a>
		</c:if>
		<c:if test="${not empty member}">
			<a href="logout.do">로그아웃</a>
			<a href="member_update.do">내정보수정</a>
		</c:if>	
			</td>
		</tr>
		<tr>
			<td align="center">예약하기 | 예약확인 | 질문하기 | 자유게시판 | 
			<a href="notice_board.do">공지사항</a> | 회사소개</td>
		</tr>
		<tr height="80%">
			<td>
				<img src="resources/img/rentcar.png" width="100%" height="100%">
			</td>
		</tr>
		<tr>
			<td align="center">
				KG 아이티뱅크 7-8월 프로젝트반
			</td>
		</tr>
	</table>
</body>
</html>