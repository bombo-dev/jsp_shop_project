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
			req.setAttribute("msg", "�Խñ� ���� ����!! �Խñ� ��� �������� �̵��մϴ�.");
			req.setAttribute("url", "board_list.board");
		}else if (res<0) {
			req.setAttribute("msg", "��й�ȣ�� Ʋ�Ƚ��ϴ�!! �ٽ� �Է��� �ּ���");
			req.setAttribute("url", "board_deleteForm.board?num=" + num);
		}else {
			req.setAttribute("msg", "�Խñ� ���� ����!! �Խñ� �󼼺��� �������� �̵��մϴ�.");
			req.setAttribute("url", "board_content.board?num=" + num);
		}
		return "message.jsp";	
	}

}
