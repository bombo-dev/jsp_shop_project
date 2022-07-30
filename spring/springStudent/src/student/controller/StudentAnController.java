package student.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import student.dao.StudentDAO;
import student.dto.StudentDTO;

@Controller
public class StudentAnController {
	
	@Autowired
	private StudentDAO studentDAO;
	
	@RequestMapping("/student.do")
	public String student() {
		return "/student/student";
	}
	//����Ÿ�� : String, ModelAndView, Model, View��ü, void
	
	@RequestMapping("/list.do")
	public String listStudent(HttpServletRequest req) {
		List<StudentDTO> list = studentDAO.listStudent();
		req.setAttribute("listStudent", list);
		return "/student/list";
	}
	
	@RequestMapping("/insert.do")
	public String insertStudent(HttpServletRequest req, 
						@ModelAttribute StudentDTO dto) {
		int res = studentDAO.insertStudent(dto);
		if (res>0) {
			req.setAttribute("msg", "�л���� ����!! �л������������ �̵��մϴ�.");
			req.setAttribute("url", "list.do");
		}else {
			req.setAttribute("msg", "�л���� ����!! �л������������� �̵��մϴ�.");
			req.setAttribute("url", "student.do");
		}
		return "/message";
	}
	
	@RequestMapping("/delete.do")
	public ModelAndView deleteStudent(@RequestParam String id) {
		int res = studentDAO.deleteStudent(id);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/message");
		if (res>0) {
			mav.addObject("msg", "�л����� ����!! �л������������ �̵��մϴ�.");
			mav.addObject("url", "list.do");
		}else {
			mav.addObject("msg", "�л����� ����!! �л������������� �̵��մϴ�.");
			mav.addObject("url", "student.do");
		}
		return mav;
	}
	
	@RequestMapping("/find.do")
	public String findStudent(HttpServletRequest req, 
										@RequestParam String name) {
		List<StudentDTO> list = studentDAO.findStudent(name);
		req.setAttribute("listStudent", list);
		return "/student/list";
	}
}









