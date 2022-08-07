package com.itbank.test;

import java.io.File;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.test.dto.StudentDTO;
import com.itbank.test.model.StudentMapper;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private StudentMapper studentMapper;
	
	@Resource(name="uploadPath")
	private String uploadPath;
	
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
	
	@RequestMapping("/student.do")
	public String student_index() {
		return "student/student";
	}
	
	@RequestMapping("/fileUpload.do")
	public String fileUpload() {
		return "fileUpload";
	}
	
	@RequestMapping("/fileUpload_ok.do")
	public String fileUpload_ok(HttpServletRequest req) {
		MultipartHttpServletRequest mr = (MultipartHttpServletRequest)req;
		MultipartFile file = mr.getFile("filename");
		String filename = file.getOriginalFilename();
		
		File target = new File(uploadPath, filename);
		if (file.getSize()>0) {
			try {
				file.transferTo(target);
				
			}catch(Exception e) {}
		}
		return "index";
	}
	
	@RequestMapping("/list.do")
	public String listStudent(HttpServletRequest req) {
		List<StudentDTO> list = studentMapper.listStudent();
		req.setAttribute("listStudent", list);
		return "/student/list";
	}
	
	@RequestMapping("/insert.do")
	public String insertStudent(HttpServletRequest req, 
						@ModelAttribute StudentDTO dto) {
		int res = studentMapper.insertStudent(dto);
		if (res>0) {
			req.setAttribute("msg", "학생등록 성공!! 학생목록페이지로 이동합니다.");
			req.setAttribute("url", "list.do");
		}else {
			req.setAttribute("msg", "학생등록 실패!! 학생관리페이지로 이동합니다.");
			req.setAttribute("url", "student.do");
		}
		return "/message";
	}
	
	@RequestMapping("/delete.do")
	public ModelAndView deleteStudent(@RequestParam String id) {
		int res = studentMapper.deleteStudent(id);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/message");
		if (res>0) {
			mav.addObject("msg", "학생삭제 성공!! 학생목록페이지로 이동합니다.");
			mav.addObject("url", "list.do");
		}else {
			mav.addObject("msg", "학생삭제 실패!! 학생관리페이지로 이동합니다.");
			mav.addObject("url", "student.do");
		}
		return mav;
	}
	
	@RequestMapping("/find.do")
	public String findStudent(HttpServletRequest req, @RequestParam String name) {
		List<StudentDTO> list = studentMapper.findStudent(name);
		req.setAttribute("listStudent", list);
		return "/student/list";
	}
}










