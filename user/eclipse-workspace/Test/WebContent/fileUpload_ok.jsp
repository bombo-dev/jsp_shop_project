<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="com.oreilly.servlet.*, java.io.*"%>
<!-- fileUpload_ok.jsp -->
<%
		///request.setCharacterEncoding("EUC-KR");
		MultipartRequest mr = null;
		String upPath = config.getServletContext().getRealPath("files");
		int len = 10*1024*1024;
		try{
			mr = new MultipartRequest(request, upPath,  len, "EUC-KR");
			//생성자의 매개변수 : 1.request 2.위치 3.크기 4.글꼴
		}catch(IOException e){
			out.println("파일 업로드 실패!!");
		}
%>
올린이 : <%=mr.getParameter("name")%><br>
파일명 : <%=mr.getFilesystemName("filename")%><br>
파일크기 : 
<%
		File file = mr.getFile("filename");
		int filesize = 0;
		if (file != null){
			filesize = (int)file.length();
		}
%>
<%=filesize%>Bytes







