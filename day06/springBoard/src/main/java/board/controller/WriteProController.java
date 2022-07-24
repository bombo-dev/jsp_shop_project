package board.controller;

import board.DAO.BoardDAO;
import board.DTO.BoardDTO;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WriteProController implements Controller {

    private BoardDAO boardDAO;

    public void setBoardDAO(BoardDAO boardDAO) {
        this.boardDAO = boardDAO;
    }

    @Override
    public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        BoardDTO dto = new BoardDTO();
        //dto.getWriter(), dto.getEmail(), dto.getSubject(), dto.getPasswd(), dto.getContent(), dto.getIp()
        dto.setWriter(req.getParameter("writer"));
        dto.setEmail(req.getParameter("email"));
        dto.setSubject(req.getParameter("subject"));
        dto.setPasswd(req.getParameter("passwd"));
        dto.setContent(req.getParameter("content"));
        dto.setIp(req.getRemoteAddr());

        int res = boardDAO.insertBoard(dto);

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
        return new ModelAndView("/message");
    }
}
