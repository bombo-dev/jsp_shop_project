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
			//�������� �Ű����� : 1.request 2.��ġ 3.ũ�� 4.�۲�
		}catch(IOException e){
			out.println("���� ���ε� ����!!");
		}
%>
�ø��� : <%=mr.getParameter("name")%><br>
���ϸ� : <%=mr.getFilesystemName("filename")%><br>
����ũ�� : 
<%
		File file = mr.getFile("filename");
		int filesize = 0;
		if (file != null){
			filesize = (int)file.length();
		}
%>
<%=filesize%>Bytes







