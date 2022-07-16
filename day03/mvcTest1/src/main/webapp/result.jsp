<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-07-16
  Time: PM 1:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    // 7번
  List<String> advice = (List)request.getAttribute("advice");
  if (advice == null || advice.size() == 0){
    %>
    <h2>준비된 데이터가 없습니다.</h2>
  <% } else { %>
    <h2>과목 선택에 따른 도움말</h2>
<%
      for(String msg : advice) { %>
          <h3> <%=msg%> </h3>
<%   }
  }
%>
