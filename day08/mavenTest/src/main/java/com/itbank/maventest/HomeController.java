package com.itbank.maventest;

import java.util.List;
import java.util.Locale;

import com.itbank.maventest.dto.StudentDTO;
import com.itbank.maventest.mapper.StudentMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private StudentMapper studentMapper;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Locale locale, Model model) {
		/*
		 * logger.info("Welcome home! The client locale is {}.", locale);
		 * 
		 * Date date = new Date(); DateFormat dateFormat =
		 * DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		 * 
		 * String formattedDate = dateFormat.format(date);
		 * 
		 * model.addAttribute("serverTime", formattedDate );
		 */
		
		return "index";
	}

	@RequestMapping("student.do")
	public String student(){
		return "student/student";
	}

	@RequestMapping("list.do")
	public String studentList(HttpServletRequest req){
		List<StudentDTO> list = studentMapper.listStudent();
		req.setAttribute("listStudent", list);
		return "/student/list";
	}

	@RequestMapping("insert.do")
	public String studentInsert(HttpServletRequest req, StudentDTO dto){
		int res = studentMapper.insertStudent(dto);

		if(res > 0) {
			req.setAttribute("msg", "학생 등록 성공!! 학생목록 페이지로 이동합니다.");
			req.setAttribute("url", "list.do");
		} else{
			req.setAttribute("msg", "학생등록 실패!! 학생 관리 페이지로 이동합니다.");
			req.setAttribute("url", "student.do");
		}
		return "/message";
	}

	@RequestMapping("delete.do")
	public String studentDelete(HttpServletRequest req, String id) {
		int res = studentMapper.deleteStudent(id);

		if (res > 0) {
			req.setAttribute("msg", "학생 삭제 성공!! 학생목록 페이지로 이동합니다.");
			req.setAttribute("url", "list.do");
		} else {
			req.setAttribute("msg", "학생삭제 실패!! 학생 관리 페이지로 이동합니다.");
			req.setAttribute("url", "student.do");
		}
		return "/message";
	}

	@RequestMapping("find.do")
	public String studentFind(HttpServletRequest req, String name){
		StudentDTO dto = studentMapper.findStudent(name);
		req.setAttribute("findStudent", dto);
		return "/student/find";
	}
}
