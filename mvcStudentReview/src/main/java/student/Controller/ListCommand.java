package student.Controller;

import student.DAO.StudentDAO;
import student.DAO.StudentDAOImpl;
import student.DTO.StudentDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListCommand implements CommandIf {
    @Override
    public Object processCommand(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        StudentDAO dao = new StudentDAOImpl();
        List<StudentDTO> list = dao.listStudent();
        req.setAttribute("listStudent", list);

        return "WEB-INF/student/list.jsp";
    }
}
