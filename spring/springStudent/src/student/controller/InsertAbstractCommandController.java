package student.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import student.dao.StudentDAO;
import student.dto.StudentDTO;

public class InsertAbstractCommandController 
							extends AbstractCommandController {
	private StudentDAO studentDAO;
	
	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	@Override
	protected ModelAndView handle(HttpServletRequest req, 
				HttpServletResponse resp, Object obj, BindException arg3)
			throws Exception {
		StudentDTO dto = (StudentDTO)obj;
		int res = studentDAO.insertStudent(dto);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/message");
		if (res>0) {
			mav.addObject("msg", "�л���� ����!! �л������������ �̵��մϴ�.");
			mav.addObject("url", "list.do");
		}else {
			mav.addObject("msg", "�л���� ����!! �л������������� �̵��մϴ�.");
			mav.addObject("url", "student.do");
		}
		return mav;
	}

}