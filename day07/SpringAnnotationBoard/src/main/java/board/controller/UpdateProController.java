package board.controller;

import board.DAO.BoardDAO;
import board.DTO.BoardDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class UpdateProController {

    @Autowired
    private BoardDAO boardDAO;

    @RequestMapping("/board_updatePro.do")
    public String updatePro(HttpServletRequest req, BoardDTO dto){
        int res = boardDAO.updateBoard(dto);

        if (res>0) {
            req.setAttribute("msg", "게시글 수정 성공!! 게시글 목록 페이지로 이동합니다.");
            req.setAttribute("url", "board_list.do");
        }else if (res<0) {
            req.setAttribute("msg", "비밀번호가 틀렸습니다!! 다시 입력해 주세요");
            req.setAttribute("url", "board_updateForm.do?num=" + dto.getNum());
        }else {
            req.setAttribute("msg", "게시글 수정 실패!! 게시글 상세보기 페이지로 이동합니다.");
            req.setAttribute("url", "board_content.do?num=" + dto.getNum());
        }
        return "/message";
    }
}
