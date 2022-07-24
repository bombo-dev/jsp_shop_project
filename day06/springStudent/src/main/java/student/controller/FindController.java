package student.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import student.DAO.StudentDAO;
import student.DTO.StudentDTO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class FindController implements Controller {

    private StudentDAO studentDAO;

    public void setStudentDAO(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String name = req.getParameter("name");
        StudentDTO dto = studentDAO.findStudent(name);
        return new ModelAndView("/student/find", "findStudent", dto);
    }
}
