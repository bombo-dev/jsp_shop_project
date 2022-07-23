<%@ page import="java.io.IOException" %>
<%@ page import="com.oreilly.servlet.MultipartRequest" %>
<%@ page import="java.io.File" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-07-23
  Time: AM 9:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  MultipartRequest mr = null;
  String upPath = config.getServletContext().getRealPath("files");
  int fileLen = 10 * 1024 * 1024;
  try {
      mr = new MultipartRequest(request, upPath, fileLen, "utf-8");
      //생성자의 매개변수 : 1.request 2.위치 3.크기 4.글꼴
  } catch(IOException e){
      out.println("파일 업로드 실패!!");
  }
%>
<%-- upload에서 보낸 올린이 이름 파라미터 --%>
올린이 : <%=mr.getParameter("name")%> <br>

<%-- upload에서 보낸 올린이 파일이름 파라미터
    파일 이름은 특별히 getFilesystemName을 사용한다.
    --%>
파일명 : <%=mr.getFilesystemName("filename")%><br>
파일크기 :
<%
    File file = mr.getFile("filename");
    int filesize = 0;
    if (file != null) {
        filesize = (int)file.length();
    }
%>
<%=filesize%>Bytes
