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

@Controller
public class WriteProController{

    @Autowired
    private BoardDAO boardDAO;

    @RequestMapping("/board_writePro.do")
    public String writePro(HttpServletRequest req, BoardDTO dto) {

        dto.setIp(req.getRemoteAddr());
        int res = BoardMapper.insertBoard(dto);

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

        return "/message";
    }
}
