package board.controller;

import board.DAO.BoardDAO;
import board.DTO.BoardDTO;
import board.resource.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class BoardListController{

//    @Autowired
//    private BoardDAO boardDAO;

//    @Autowired
//    public BoardListController(BoardDAO boardDAO){
//        this.boardDAO = boardDAO;
//    }

    @RequestMapping("/board_list.do")
    public String listBoard(HttpServletRequest req){
//        List<BoardDTO>list = boardDAO.listBoard();
        List<BoardDTO> list = BoardMapper.listBoard();
        req.setAttribute("boardList", list);
        return "/board/list";
    }
}
