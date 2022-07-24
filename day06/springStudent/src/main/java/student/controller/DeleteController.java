package student.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import student.DAO.StudentDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteController implements Controller {

    private StudentDAO studentDAO;

    public void setStudentDAO(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        String id = req.getParameter("id");
        int res = studentDAO.deleteStudent(id);

        ModelAndView mav = new ModelAndView("/message");

        if(res > 0) {
            mav.addObject("msg", "학생 삭제 성공!! 학생목록 페이지로 이동합니다.");
            mav.addObject("url", "list.do");
        } else{
            mav.addObject("msg", "학생삭제 실패!! 학생 관리 페이지로 이동합니다.");
            mav.addObject("url", "student.do");
        }

        return mav;
    }
}
