package board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.BoardDAO;
import board.dao.BoardDAOImpl;
import board.dto.BoardDTO;

public class BoardWriteProCommand implements CommandIf {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		BoardDTO dto = new BoardDTO();
		dto.setWriter(req.getParameter("writer"));
		dto.setEmail(req.getParameter("email"));
		dto.setSubject(req.getParameter("subject"));
		dto.setPasswd(req.getParameter("passwd"));
		dto.setContent(req.getParameter("content"));
		dto.setIp(req.getRemoteAddr());
		BoardDAO dao = new BoardDAOImpl();
		int res = dao.insertBoard(dto);
		if (res>0) {
			req.setAttribute("msg", "�Խñ� ��� ����!! �Խñ� ��� �������� �̵��մϴ�.");
			req.setAttribute("url", "board_list.board");
		}else {
			req.setAttribute("msg", "�Խñ� ��� ����!! �Խñ� ��� �������� �̵��մϴ�.");
			req.setAttribute("url", "board_writeForm.board");
		}
		return "message.jsp";
	}

}







