package board.Controller;

import board.DAO.BoardDAO;
import board.DAO.BoardDAOImpl;
import board.DTO.BoardDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BoardWriteProCommand implements CommandIf {
    @Override
    public Object processCommand(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        BoardDTO dto = new BoardDTO();
        dto.setWriter(req.getParameter("writer"));
        dto.setSubject(req.getParameter("subject"));
        dto.setEmail(req.getParameter("email"));
        dto.setPasswd(req.getParameter("passwd"));
        dto.setContent(req.getParameter("content"));
        dto.setIp(req.getRemoteAddr());

        BoardDAO dao = new BoardDAOImpl();

        System.out.println("dto의 상태 " + dto.toString());
        int res = dao.insertBoard(dto);

        if ( res > 0 ) {
            String msg = "게시글 등록 성공!! 게시글 목록 페이지로 이동합니다.";
            String url = "board_list.do";
            req.setAttribute("msg", msg);
            req.setAttribute("url", url);
        } else {
            String msg = "게시글 등록 실패!! 게시글 작성 페이지로 이동합니다.";
            String url = "board_writeForm.do";
            req.setAttribute("msg", msg);
            req.setAttribute("url", url);
        }

        return "message.jsp";
    }
}
