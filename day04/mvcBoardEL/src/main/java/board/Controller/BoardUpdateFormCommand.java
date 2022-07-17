package board.Controller;

import board.DAO.BoardDAO;
import board.DAO.BoardDAOImpl;
import board.DTO.BoardDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BoardUpdateFormCommand implements CommandIf {
    @Override
    public Object processCommand(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String num = req.getParameter("num");
        BoardDAO dao = new BoardDAOImpl();
        BoardDTO dto = dao.getBoard(Integer.parseInt(num), "update");
        req.setAttribute("update", dto);

        return "WEB-INF/board/updateForm.jsp";
    }
}
