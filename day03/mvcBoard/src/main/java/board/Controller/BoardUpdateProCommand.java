package board.Controller;

import board.DAO.BoardDAO;
import board.DAO.BoardDAOImpl;
import board.DTO.BoardDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BoardUpdateProCommand implements CommandIf {
    @Override
    public Object processCommand(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String num = req.getParameter("num");
        BoardDTO dto = new BoardDTO();
        dto.setNum(Integer.parseInt(num));
        dto.setWriter(req.getParameter("writer"));
        dto.setSubject(req.getParameter("subject"));
        dto.setEmail(req.getParameter("email"));
        dto.setContent(req.getParameter("content"));
        dto.setPasswd(req.getParameter("passwd"));
        BoardDAO dao = new BoardDAOImpl();
        int res = dao.updateBoard(dto);


        if ( res > 0 ) {
            String msg = "게시글 수정 성공!! 게시글 목록 페이지로 이동합니다.";
            String url = "board_list.do";
            req.setAttribute("msg", msg);
            req.setAttribute("url", url);
        } else if (res < 0){
            String msg = "비밀번호가 틀렸습니다. 다시 입력해주세요.";
            String url = "board_updateForm.do?num="+dto.getNum();
            req.setAttribute("msg", msg);
            req.setAttribute("url", url);
        } else {
            String msg = "게시글 수정 실패!! 게시글 상세보기 페이지로 이동합니다.";
            String url = "board_content.do?num="+dto.getNum();
            req.setAttribute("msg", msg);
            req.setAttribute("url", url);
        }

        return "message.jsp";
    }
}
