<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.util.*"%>
<!-- result.jsp -->
<%
		List<String> advice = (List)request.getAttribute("advice");
		if (advice == null || advice.size()==0){%>
			<h2>�غ�� �����Ͱ� �����ϴ�.</h2>	
<%	}else {%>
			<h2>���� ���ÿ� ���� ����</h2>
<%		for(String msg : advice) {%>
			<h3><%=msg%></h3>
<%		} %>			
<%	}%>