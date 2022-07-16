package mvc1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DepartServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=EUC-KR");
		String depart = req.getParameter("depart");
		//PrintWriter pw = resp.getWriter();
		//pw.println("넘어온 데이터 : " + depart);
		DepartExpert de = new DepartExpert();
		List<String> advice = de.getAdvice(depart);
		req.setAttribute("advice", advice);
		RequestDispatcher view = req.getRequestDispatcher("result.jsp");
		view.forward(req, resp);
	}
}
/*
	1. HttpServlet클래스를 상속받는다
	2. doGet(), doPost(), service()메소드 중 하나를 오버라이드 해준다
	3. web.xml에 Servlet클래스를 등록한다
*/