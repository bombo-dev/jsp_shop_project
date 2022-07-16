package student;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FindCommand implements CommandIf{

	@Override
	public String processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String name = req.getParameter("name");
		StudentDAO dao = new StudentDAO();
		List<StudentDTO> list = dao.findStudent(name);
		req.setAttribute("listStudent", list);
		return "list.jsp";
	}

}
