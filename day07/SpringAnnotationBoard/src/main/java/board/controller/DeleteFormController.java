package board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class DeleteFormController{

    public String deleteForm(HttpServletRequest req, int num) {

        req.setAttribute("num", num);

        return "/board/deleteForm";
    }
}
