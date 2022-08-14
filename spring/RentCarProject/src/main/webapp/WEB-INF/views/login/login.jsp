<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!-- login.jsp-->
<link rel="stylesheet" type="text/css" href="resources/style.css">
<script type="text/javascript">
	function searchMember(mode){
	window.open("login_search.do?mode="+mode,"", "width=640, height=400");
	}
	function checkMember(mode){
		window.open("memberSsn.do", "", "width=640, height=400")
	}	
	function loginCheck(){
		if (f.id.value==""){
			alert("아이디를 입력하세요!!")
			f.id.focus()
			return
		}
		if (f.passwd.value==""){
			alert("비밀번호를 입력하세요!!")
			f.passwd.focus()
			return
		}
		document.f.submit()
	}
</script>
<div align="center">
<br>
<img src="resources/img/bottom.gif" width=570 height="40" border="0" alt="">
<br>
<p>
<img src="resources/img/tm_login.gif" width=100 height="13" border="0" 
	align="center" ALT="회원 로그인">
<form name="f" action="login_ok.do" method="post">
	<table width="60%" align="center" height="120">
		<tr>
			<td align="right" width="30%">
				<img src="resources/img/id01.gif" 
				width="28" height="11" border="0" alt="아이디">&nbsp;&nbsp;
			</td>
			<td width="40%">
			<c:if test="${empty cookie.saveId}">			
				<input type="text" name="id" tabindex="1">
			</c:if>	
			<c:if test="${not empty cookie.saveId}">	
				<input type="text" name="id" value="${cookie.saveId.value}" tabindex="1">
			</c:if>				
			</td>
			<td rowspan="2" width="30%" valign="middle">
				<a href="javascript:loginCheck()">
					<img src="resources/img/bt_login.gif" border="0" alt="로그인"  tabindex="3">&nbsp;&nbsp;<br>
				</a>
				<nobr>
			<c:if test="${empty cookie.saveId}">				
					<input type="checkbox" name="saveId">
			</c:if>
			<c:if test="${not empty cookie.saveId}">		
					<input type="checkbox" name="saveId" checked>					
			</c:if>				
					<font face="굴림" size="2">아이디 기억하기</font>
				</nobr>
			</td>
		</tr>
		<tr>
			<td align="right">
				<img src="resources/img/pwd.gif" 
							width="37" height="11" alt="비밀번호">
			</td>
			<td>
				<input type="password" name="passwd"  tabindex="2">
			</td>
		</tr>
		<tr>
			<td colspan="3" align="center">
				<a href="javascript:checkMember()">
					<img src="resources/img/bt_join.gif" width="60" height="22" alt="회원가입">
				</a>	
 					<a href="javascript:searchMember('id')">
 					<img src="resources/img/bt_search_id.gif" border="0" width="60" height="22" alt="아이디 찾기">
 				</a>	
 				<a href="javascript:searchMember('pw')">
					<img src="resources/img/bt_search_pw.gif" border="0" width="60" height="22" alt="비밀번호 찾기">
				</a>
			</td>
		</tr>
	</table>
</form> 
</div>





