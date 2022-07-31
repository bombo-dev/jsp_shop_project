package com.itbank.springMaven;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.springMaven.dto.BoardDTO;
import com.itbank.springMaven.service.BoardMapper;

@Controller
public class BoardController {

	@Autowired
	private BoardMapper boardMapper;
		
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "index";
	}
	
	@RequestMapping("/board_list.do")
	public String listBoard(HttpServletRequest req) {
		List<BoardDTO> list = boardMapper.listBoard();
		req.setAttribute("listBoard", list);
		return "board/list";
	}
	
	@RequestMapping(value="/board_write.do", method=RequestMethod.GET)
	public String writeFormBoard() {
		return "board/writeForm";
	}
	
	@RequestMapping(value="/board_write.do", method=RequestMethod.POST)
	public String writeProBoard(HttpServletRequest req, BoardDTO dto) {
		dto.setIp(req.getRemoteAddr());
		int res = boardMapper.insertBoard(dto);
		if (res>0) {
			req.setAttribute("msg", "게시글등록 성공!! 게시글목록페이지로 이동합니다.");
			req.setAttribute("url", "board_list.do");
		}else {
			req.setAttribute("msg", "게시글등록 실패!! 게시글등록페이지로 이동합니다.");
			req.setAttribute("url", "board_writeForm.do");
		}
		return "message";
	}
	
	@RequestMapping("/board_content.do")
	public ModelAndView contentBoard(int num){
		BoardDTO dto = boardMapper.getBoard(num, "content");
		return new ModelAndView("board/content", "getBoard", dto);
	}
	
	@RequestMapping(value="/board_delete.do", method=RequestMethod.GET)
	public String deleteFormBoard() {
		return "board/deleteForm";
	}
	
	@RequestMapping(value="/board_delete.do", method=RequestMethod.POST)
	public String deleteProBoard(HttpServletRequest req, 
											@RequestParam Map<String, String> params) {
		int res = boardMapper.deleteBoard(
				Integer.parseInt(params.get("num")), params.get("passwd")); 
		if (res>0) {
			req.setAttribute("msg", "게시글삭제 성공!! 게시글목록페이지로 이동합니다.");
			req.setAttribute("url", "board_list.do");
		}else if (res<0) {
			req.setAttribute("msg", "비밀번호가 틀렸습니다. 다시 입력해 주세요!!");
			req.setAttribute("url", "board_delete.do?num="+params.get("num"));
		}else {
			req.setAttribute("msg", "게시글삭제 실패!! 게시글상세보기페이지로 이동합니다.");
			req.setAttribute("url", "board_content.do?num="+params.get("num"));
		}
		return "message";
	}
	
	@RequestMapping(value="/board_update.do", method=RequestMethod.GET)
	public ModelAndView updateFormBoard(int num){
		BoardDTO dto = boardMapper.getBoard(num, "update");
		return new ModelAndView("board/updateForm", "getBoard", dto);
	}
	
	@RequestMapping(value="/board_update.do", method=RequestMethod.POST)
	public String updateProBoard(HttpServletRequest req, BoardDTO dto) {
		int res = boardMapper.updateBoard(dto);
		if (res>0) {
			req.setAttribute("msg", "게시글수정 성공!! 게시글목록페이지로 이동합니다.");
			req.setAttribute("url", "board_list.do");
		}else if (res<0) {
			req.setAttribute("msg", "비밀번호가 틀렸습니다. 다시 입력해 주세요!!");
			req.setAttribute("url", "board_update.do?num="+dto.getNum());
		}else {
			req.setAttribute("msg", "게시글수정 실패!! 게시글상세보기페이지로 이동합니다.");
			req.setAttribute("url", "board_content.do?num="+dto.getNum());
		}
		return "message";
	}
}













