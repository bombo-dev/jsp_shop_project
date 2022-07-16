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
		//pw.println("�Ѿ�� ������ : " + depart);
		DepartExpert de = new DepartExpert();
		List<String> advice = de.getAdvice(depart);
		req.setAttribute("advice", advice);
		RequestDispatcher view = req.getRequestDispatcher("result.jsp");
		view.forward(req, resp);
	}
}
/*
	1. HttpServletŬ������ ��ӹ޴´�
	2. doGet(), doPost(), service()�޼ҵ� �� �ϳ��� �������̵� ���ش�
	3. web.xml�� ServletŬ������ ����Ѵ�
*/