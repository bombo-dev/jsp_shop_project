package com.kgitbank.rentcar;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kgitbank.rentcar.dto.NoticeBoardDTO;
import com.kgitbank.rentcar.model.NoticeBoardMapper;

@Controller
public class BoardController {

	@Autowired
	NoticeBoardMapper noticeBoardMapper;
	
	@RequestMapping("/adminBoard_list.do")
	public String adminBoard_list() {
		return "/admin/board/index";
	}
	
	@RequestMapping("/notice_board.do")
	public String notice_board_list(HttpServletRequest req) {
		List<NoticeBoardDTO> dto = noticeBoardMapper.listBoard();
		req.setAttribute("listBoard", dto);
		return "/board/notice/list";
	}
	
	@RequestMapping(value="/notice_board_write.do", method=RequestMethod.GET)
	public String writeFormBoard() {
		return "board/notice/writeForm";
	}
	
	@RequestMapping(value="/notice_board_write.do", method=RequestMethod.POST)
	public String writeProBoard(HttpServletRequest req, NoticeBoardDTO dto) {
		int res = noticeBoardMapper.insertBoard(dto);
		if (res>0) {
			req.setAttribute("msg", "게시글등록 성공!! 게시글목록페이지로 이동합니다.");
			req.setAttribute("url", "notice_board.do");
		}else {
			req.setAttribute("msg", "게시글등록 실패!! 게시글등록페이지로 이동합니다.");
			req.setAttribute("url", "notice_board_write.do");
		}
		return "message";
	}
	
	@RequestMapping("/notice_board_content.do")
	public String contentBoard(HttpServletRequest req, int num){
		NoticeBoardDTO dto = noticeBoardMapper.getBoard(num, "content");
		req.setAttribute("getBoard", dto);
		return "/board/notice/content";
	}
}







