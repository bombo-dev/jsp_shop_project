package student;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertCommand implements CommandIf{

	@Override
	public String processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		StudentDTO dto = new StudentDTO();
		dto.setId(req.getParameter("id"));
		dto.setName(req.getParameter("name"));
		dto.setCname(req.getParameter("cname"));
		StudentDAO dao = new StudentDAO();
		int res = dao.insertStudent(dto);
		String msg = null, url = null;
		if (res>0) {
			msg = "�л���� ����!! �л������������ �̵��մϴ�.";
			url = "student.do?command=list";
		}else {
			msg = "�л���� ����!! �л������������� �̵��մϴ�.";
			url = "student.do?command=index";
		}
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		return "message.jsp";
	}

}
