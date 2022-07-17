package board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.BoardDAO;
import board.dao.BoardDAOImpl;

public class BoardDeleteProCommand implements CommandIf {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String num = req.getParameter("num");
		String passwd = req.getParameter("passwd");
		BoardDAO dao = new BoardDAOImpl();
		int res = dao.deleteBoard(Integer.parseInt(num), passwd);
		if (res>0) {
			req.setAttribute("msg", "게시글 삭제 성공!! 게시글 목록 페이지로 이동합니다.");
			req.setAttribute("url", "board_list.board");
		}else if (res<0) {
			req.setAttribute("msg", "비밀번호가 틀렸습니다!! 다시 입력해 주세요");
			req.setAttribute("url", "board_deleteForm.board?num=" + num);
		}else {
			req.setAttribute("msg", "게시글 삭제 실패!! 게시글 상세보기 페이지로 이동합니다.");
			req.setAttribute("url", "board_content.board?num=" + num);
		}
		return "message.jsp";	
	}

}
