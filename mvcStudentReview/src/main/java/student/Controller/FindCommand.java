package student.Controller;

import student.DAO.StudentDAO;
import student.DAO.StudentDAOImpl;
import student.DTO.StudentDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FindCommand implements CommandIf{
    @Override
    public Object processCommand(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");

        StudentDAO dao = new StudentDAOImpl();
        StudentDTO dto = dao.getStudent(name);

        req.setAttribute("findStudent", dto);

        return "WEB-INF/student/find.jsp";
    }
}
