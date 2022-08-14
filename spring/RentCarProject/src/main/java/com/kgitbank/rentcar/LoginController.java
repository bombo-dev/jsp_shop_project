package com.kgitbank.rentcar;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kgitbank.rentcar.dto.MemberDTO;
import com.kgitbank.rentcar.model.MemberMapper;

@Controller
public class LoginController {
	
	@Autowired
	MemberMapper memberMapper;
	
	@RequestMapping("/login.do")
	public String login() {
		return "/login/login";
	}
	
	@RequestMapping("/logout.do")
	public String logout(HttpServletRequest req) {
		HttpSession session = req.getSession();
		session.invalidate();
		return "/login/logout";
	}
		
	@RequestMapping("/login_search.do")
	public String login_search() {
		return "/login/search";
	}
	
	@RequestMapping("/login_check.do")
	public String login_check(HttpServletRequest req, @RequestParam Map<String, String> params) {
		String msg = memberMapper.searchMember(params);
		req.setAttribute("msg", msg);
		req.setAttribute("url", "javascript:self.close()");
		return "/message";
	}
	
	@RequestMapping("/login_ok.do")
	public String login_ok(HttpServletRequest req, HttpServletResponse resp, @RequestParam Map<String, String> params) {
		MemberDTO dto = memberMapper.LoginOk(params.get("id"));
		if (dto == null) {
			req.setAttribute("msg", "없는 아이디 입니다. 다시 입력해 주세요!!");
			req.setAttribute("url", "login.do");
		}else {
			if (dto.getPasswd().equals(params.get("passwd"))) {
				HttpSession session = req.getSession();
				session.setAttribute("member", dto);
				Cookie ck = new Cookie("saveId", dto.getId());
				if (params.containsKey("saveId")) {
					ck.setMaxAge(24*60*60);
				}else {
					ck.setMaxAge(0);
				}
				resp.addCookie(ck);
				if (dto.getId().equals("admin")) {
					return "/admin/adminIndex";
				}
				req.setAttribute("msg", "로그인 되었습니다.");
				req.setAttribute("url", "index.do");
			}else {
				req.setAttribute("msg", "비밀번호가 틀렸습니다. 다시 입력해 주세요!!");
				req.setAttribute("url", "login.do");
			}
		}
		return "/message";
	}
}








