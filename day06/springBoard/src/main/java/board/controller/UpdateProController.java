package board.controller;

import board.DAO.BoardDAO;
import board.DTO.BoardDTO;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateProController implements Controller {

    private BoardDAO boardDAO;

    public void setBoardDAO(BoardDAO boardDAO) {
        this.boardDAO = boardDAO;
    }

    @Override
    public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        BoardDTO dto = new BoardDTO();
        dto.setEmail(req.getParameter("email"));
        dto.setSubject(req.getParameter("subject"));
        dto.setPasswd(req.getParameter("passwd"));
        dto.setContent(req.getParameter("content"));
        dto.setNum(Integer.parseInt(req.getParameter("num")));

        int res = boardDAO.updateBoard(dto);

        ModelAndView mav = new ModelAndView("/message");
        if (res>0) {
            mav.addObject("msg", "게시글 수정 성공!! 게시글 목록 페이지로 이동합니다.");
            mav.addObject("url", "board_list.do");
        }else if (res<0) {
            mav.addObject("msg", "비밀번호가 틀렸습니다!! 다시 입력해 주세요");
            mav.addObject("url", "board_updateForm.do?num=" + dto.getNum());
        }else {
            mav.addObject("msg", "게시글 수정 실패!! 게시글 상세보기 페이지로 이동합니다.");
            mav.addObject("url", "board_content.do?num=" + dto.getNum());
        }
        return mav;
    }
}
