package board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.BoardDAO;
import board.dao.BoardDAOImpl;
import board.dto.BoardDTO;

public class BoardUpdateProCommand implements CommandIf {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		BoardDTO dto = new BoardDTO();
		dto.setEmail(req.getParameter("email"));
		dto.setSubject(req.getParameter("subject"));
		dto.setPasswd(req.getParameter("passwd"));
		dto.setContent(req.getParameter("content"));
		dto.setNum(Integer.parseInt(req.getParameter("num")));
		BoardDAO dao = new BoardDAOImpl();
		int res = dao.updateBoard(dto);
		if (res>0) {
			req.setAttribute("msg", "게시글 수정 성공!! 게시글 목록 페이지로 이동합니다.");
			req.setAttribute("url", "board_list.board");
		}else if (res<0) {
			req.setAttribute("msg", "비밀번호가 틀렸습니다!! 다시 입력해 주세요");
			req.setAttribute("url", "board_updateForm.board?num=" + dto.getNum());
		}else {
			req.setAttribute("msg", "게시글 수정 실패!! 게시글 상세보기 페이지로 이동합니다.");
			req.setAttribute("url", "board_content.board?num=" + dto.getNum());
		}
		return "message.jsp";	
	}

}
