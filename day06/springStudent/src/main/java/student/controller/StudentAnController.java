package student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import student.DAO.StudentDAO;
import student.DTO.StudentDTO;
import student.mybatis.StudentMapper;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class StudentAnController {

    @Autowired
    private StudentDAO studentDAO;
//    public void setStudentDAO(StudentDAO studentDAO) {
//        this.studentDAO = studentDAO;
//    }

    @RequestMapping("/student.do")
    public String student() {
        return "/student/student";
    }
    //리턴타입 : String, ModelAndView, Model, View객체, void

    @RequestMapping("/list.do")
    public String listStudent(HttpServletRequest req) {
//        List<StudentDTO> list = studentDAO.listStudent();
        List<StudentDTO> list = StudentMapper.listStudent();
        req.setAttribute("listStudent", list);
        return "student/list";
    }

    @RequestMapping("/insert.do")
    public String insertStudent(HttpServletRequest req, @ModelAttribute StudentDTO dto) {
//        int res = studentDAO.insertStudent(dto);
        int res = StudentMapper.insertStudent(dto);
        if(res > 0) {
            req.setAttribute("msg", "학생 등록 성공!! 학생목록 페이지로 이동합니다.");
            req.setAttribute("url", "list.do");
        } else{
            req.setAttribute("msg", "학생등록 실패!! 학생 관리 페이지로 이동합니다.");
            req.setAttribute("url", "student.do");
        }
        return "/message";
    }

    @RequestMapping("/delete.do")
    public ModelAndView deleteStudent(@RequestParam String id){
//        int res = studentDAO.deleteStudent(id);
        int res = StudentMapper.deleteStudent(id);
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

    @RequestMapping("/find.do")
    public String findStudent(HttpServletRequest req, String name){
//        StudentDTO dto = studentDAO.findStudent(name);
        List<StudentDTO> list = StudentMapper.findStudent(name);
        req.setAttribute("findStudent", list);
        return "student/find";
    }
}
