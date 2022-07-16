<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.util.*"%>
<!-- result.jsp -->
<%
		List<String> advice = (List)request.getAttribute("advice");
		if (advice == null || advice.size()==0){%>
			<h2>준비된 데이터가 없습니다.</h2>	
<%	}else {%>
			<h2>과목 선택에 따른 도움말</h2>
<%		for(String msg : advice) {%>
			<h3><%=msg%></h3>
<%		} %>			
<%	}%>