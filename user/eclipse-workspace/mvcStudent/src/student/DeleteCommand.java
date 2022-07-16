package student;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteCommand implements CommandIf{

	@Override
	public String processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String id = req.getParameter("id");
		StudentDAO dao = new StudentDAO();
		int res = dao.deleteStudent(id);
		String msg = null, url = null;
		if (res>0) {
			msg = "학생삭제 성공!! 학생목록페이지로 이동합니다.";
			url = "student.do?command=list";
		}else {
			msg = "학생삭제 실패!! 학생관리페이지로 이동합니다.";
			url = "student.do?command=index";
		}
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		return "message.jsp";
	}

}
