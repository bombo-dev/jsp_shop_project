package member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;

public class MemberServlet extends HttpServlet {

	@Override  
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
														throws ServletException, IOException {
		req.setCharacterEncoding("EUC-KR");
		resp.setContentType("text/html; charset=EUC-KR");
		PrintWriter pw = resp.getWriter();
		pw.println("<h2> MemberServlet�� �Ծ��!!</h2>");
	}
}
