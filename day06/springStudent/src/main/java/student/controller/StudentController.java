package student.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //ModelAndView 객체 만들기

        //1. ModelAndView mav = new ModelAndView();
        // - mav.setViewName(nextPage);
        // - mav.addObject(key, value);

        //2. ModelAndView mav = new ModelAndView(nextPage);
        // - mav.addObject(key, value);

        //3. ModelAndView mav = new ModelAndView(nextPage, key, value);

        ModelAndView mav = new ModelAndView();
        mav.setViewName("/student/student");
        return mav;

    }
}
