package student;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListCommand implements CommandIf{

	@Override
	public String processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		StudentDAO dao = new StudentDAO();
		List<StudentDTO> list = dao.listStudent();
		req.setAttribute("listStudent", list);
		return "list.jsp";
	}

}
