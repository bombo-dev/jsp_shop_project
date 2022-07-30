package board.controller;

import board.DAO.BoardDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class DeleteProController {

    @Autowired
    private BoardDAO boardDAO;

    @RequestMapping("/board_deletePro.do")
    public String deletePro(HttpServletRequest req){

        String num = req.getParameter("num");
        String passwd = req.getParameter("passwd");

        int res = boardDAO.deleteBoard(Integer.parseInt(num), passwd);

        if (res>0) {
            req.setAttribute("msg", "게시글 삭제 성공!! 게시글 목록 페이지로 이동합니다.");
            req.setAttribute("url", "board_list.do");
        }else if (res<0) {
            req.setAttribute("msg", "비밀번호가 틀렸습니다!! 다시 입력해 주세요");
            req.setAttribute("url", "board_deleteForm.do?num=" + num);
        }else {
            req.setAttribute("msg", "게시글 삭제 실패!! 게시글 상세보기 페이지로 이동합니다.");
            req.setAttribute("url", "board_content.do?num=" + num);
        }
        return "/message";
    }
}
