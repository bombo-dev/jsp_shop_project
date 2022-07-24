package board.controller;

import board.DAO.BoardDAO;
import board.DTO.BoardDTO;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WriteFormController implements Controller {

    private BoardDAO boardDAO;

    public void setBoardDAO(BoardDAO boardDAO) {
        this.boardDAO = boardDAO;
    }

    @Override
    public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        return new ModelAndView("/board/writeForm");
    }
}
