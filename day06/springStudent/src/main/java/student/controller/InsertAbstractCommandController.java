package student.controller;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;
import student.DAO.StudentDAO;
import student.DTO.StudentDTO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertAbstractCommandController extends AbstractCommandController {

    private StudentDAO studentDAO;
    public void setStudentDAO(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    protected ModelAndView handle(HttpServletRequest req, HttpServletResponse resp, Object obj, BindException e) throws Exception {
        StudentDTO dto = (StudentDTO)obj;
        int res = studentDAO.insertStudent(dto);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/message");

        if(res > 0) {
            mav.addObject("msg", "학생 등록 성공!! 학생목록 페이지로 이동합니다.");
            mav.addObject("url", "list.do");
        } else{
            mav.addObject("msg", "학생등록 실패!! 학생 관리 페이지로 이동합니다.");
            mav.addObject("url", "student.do");
        }
        return mav;
    }
}
