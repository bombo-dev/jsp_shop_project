package member.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import member.dao.MemberDAO;
import member.dto.MemberDTO;
import member.mybatis.MemberMapper;

@Controller
public class MemberController {
	
	@RequestMapping("/member_index.do")
	public String member_index() {
		return "/member/index";
	}
	
	@RequestMapping("/memberSsn.do")
	public String memberSsn() {
		return "/member/memberSsn";
	}
	
	@RequestMapping("/member_check.do")
	public String memberCheck(HttpServletRequest req, @RequestParam Map<String, String> params) {
		//boolean isMember = memberDAO.checkMember(params.get("name"), 
		//							params.get("ssn1"), params.get("ssn2"));
		boolean isMember = MemberMapper.checkMember(params);
		if (isMember) {
			req.setAttribute("msg", "�̹� ȸ���̽ʴϴ�. �α����� �� �ּ���!!");
			req.setAttribute("url", "member_index.do");
		}else {
			return "/member/member_input";
		}
		return "/message";
	}
	
	@RequestMapping("/member_input_ok.do")
	public String memberInput(HttpServletRequest req, MemberDTO dto) {
		//int res = memberDAO.insertMember(dto);
		int res = MemberMapper.insertMember(dto);
		if (res>0) {
			req.setAttribute("msg", "ȸ����� ����!! ȸ�������������� �̵��մϴ�.");
			req.setAttribute("url", "member_index.do");
		}else {
			req.setAttribute("msg", "ȸ����� ����!! ȸ������������� �̵��մϴ�.");
			req.setAttribute("url", "memberSsn.do");
		}
		return "/message";
	}
	
	@RequestMapping("/memberAll.do")
	public String memberAll(HttpServletRequest req, 
					@RequestParam(required=false) String mode) {
		List<MemberDTO> list = null;
		if (mode == null) {
			mode = "all";
			//list = memberDAO.listMember();
			list = MemberMapper.listMember();
		}else {
			String search = req.getParameter("search");
			String searchString = req.getParameter("searchString");
			//list = memberDAO.findMember(search, searchString);
			list = MemberMapper.findMember(search, searchString);
		}
		req.setAttribute("mode", mode);
		req.setAttribute("listMember", list);
		return "/member/memberAll";		
	}
	
	@RequestMapping("/member_delete.do")
	public String member_delete(HttpServletRequest req, int no) {
		//int res = memberDAO.deleteMember(no);
		int res = MemberMapper.deleteMember(no);
		if (res>0) {
			req.setAttribute("msg", "ȸ������ ����!! ȸ�������������� �̵��մϴ�.");
			req.setAttribute("url", "member_index.do");
		}else {
			req.setAttribute("msg", "ȸ������ ����!! ȸ�������������� �̵��մϴ�.");
			req.setAttribute("url", "member_index.do");
		}
		return "/message";
	}

	@RequestMapping(value="/member_update.do", method=RequestMethod.GET)
	public String member_update(HttpServletRequest req, int no) {
		//MemberDTO dto = memberDAO.getMember(no);
		MemberDTO dto = MemberMapper.getMember(no);
		req.setAttribute("getMember", dto);
		return "/member/member_update";
	}
	
	@RequestMapping(value="/member_update.do", method=RequestMethod.POST)
	public String member_update_ok(HttpServletRequest req, MemberDTO dto) {
		//int res = memberDAO.updateMember(dto);
		int res = MemberMapper.updateMember(dto);
		if (res>0) {
			req.setAttribute("msg", "ȸ������ ����!! ȸ�������������� �̵��մϴ�.");
			req.setAttribute("url", "member_index.do");
		}else {
			req.setAttribute("msg", "ȸ������ ����!! ȸ�������������� �̵��մϴ�.");
			req.setAttribute("url", "member_update.do?no="+dto.getNo());
		}
		return "/message";
	}
}









