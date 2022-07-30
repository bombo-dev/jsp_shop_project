package board.controller;

import board.DAO.BoardDAO;
import board.DTO.BoardDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ContentController{

    @Autowired
    private BoardDAO boardDAO;

    @RequestMapping("/board_content.do")
    public String contentBoard(HttpServletRequest req){

        String num = req.getParameter("num");
        BoardDTO dto = boardDAO.getBoard(Integer.parseInt(num), "content");

        req.setAttribute("content", dto);

        return "/board/content";
    }
}
