package board.controller;

import board.DAO.BoardDAO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class WriteFormController {

    @RequestMapping("/board_writeForm.do")
    public String writeForm(){
        return "/board/writeForm";
    }
}
