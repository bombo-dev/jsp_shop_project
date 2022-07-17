package board.Controller;

import board.DAO.BoardDAO;
import board.DAO.BoardDAOImpl;
import board.DTO.BoardDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class BoardListCommand implements CommandIf{
    @Override
    public Object processCommand(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        BoardDAO dao = new BoardDAOImpl();
        List<BoardDTO> list = dao.listBoard();
        req.setAttribute("boardList", list);
        return "WEB-INF/board/list.jsp";
    }
}
