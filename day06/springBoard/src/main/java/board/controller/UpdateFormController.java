package board.controller;

import board.DAO.BoardDAO;
import board.DTO.BoardDTO;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateFormController implements Controller {

    private BoardDAO boardDAO;

    public void setBoardDAO(BoardDAO boardDAO) {
        this.boardDAO = boardDAO;
    }

    @Override
    public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        String num = req.getParameter("num");

        BoardDTO dto = boardDAO.getBoard(Integer.parseInt(num), "");

        return new ModelAndView("/board/updateForm", "update", dto);
    }
}
