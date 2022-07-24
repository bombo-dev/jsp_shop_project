package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import board.dao.BoardDAO;
import board.dto.BoardDTO;

public class BoardWriteProAbstractCommandController extends AbstractCommandController {
	private BoardDAO boardDAO;
	
	public void setBoardDAO(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}

	@Override
	protected ModelAndView handle(HttpServletRequest req, HttpServletResponse arg1, Object obj, BindException arg3)
			throws Exception {
		BoardDTO dto = (BoardDTO)obj;
		dto.setIp(req.getRemoteAddr());
		int res = boardDAO.insertBoard(dto);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/message");
		if (res>0) {
			mav.addObject("msg", "�Խñ۵�� ����!! �Խñ۸���������� �̵��մϴ�.");
			mav.addObject("url", "board_list.do");
		}else {
			mav.addObject("msg", "�Խñ۵�� ����!! �Խñ۵���������� �̵��մϴ�.");
			mav.addObject("url", "board_writeForm.do");
		}
		return mav;
	}

}
