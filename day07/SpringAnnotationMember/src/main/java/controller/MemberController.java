package controller;

import dao.MemberDAO;
import dto.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class MemberController {

    @Autowired
    private MemberDAO memberDAO;

    @RequestMapping("/member_index.do")
    public String member_index() {
        return "/member/index";
    }

    @RequestMapping("/memberSsn.do")
    public String memberSsn() {
        return "/member/memberSsn";
    }

    @RequestMapping("/member_check.do")
    public String memberCheck(HttpServletRequest req, Map<String, String> params) {
        boolean isMember = memberDAO.checkMember(params.get("name"),
                params.get("ssn1"), params.get("ssn2"));
        if (isMember) {
            req.setAttribute("msg", "이미 회원이십니다. 로그인을 해 주세요!!");
            req.setAttribute("url", "member_index.do");
        }else {
            return "/member/member_input";
        }
        return "/message";
    }

    @RequestMapping("/member_input_ok.do")
    public String memberInput(HttpServletRequest req, MemberDTO dto) {
        int res = memberDAO.insertMember(dto);
        if (res>0) {
            req.setAttribute("msg", "회원등록 성공!! 회원관리페이지로 이동합니다.");
            req.setAttribute("url", "member_index.do");
        }else {
            req.setAttribute("msg", "회원등록 실패!! 회원등록페이지로 이동합니다.");
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
            list = memberDAO.listMember();
        }else {
            String search = req.getParameter("search");
            String searchString = req.getParameter("searchString");
            list = memberDAO.findMember(search, searchString);
        }
        req.setAttribute("mode", mode);
        req.setAttribute("list", list);
        return "/member/memberAll";
    }

    @RequestMapping("/member_delete.do")
    public String member_delete(HttpServletRequest req, int no) {
        int res = memberDAO.deleteMember(no);
        if (res>0) {
            req.setAttribute("msg", "회원삭제 성공!! 회원관리페이지로 이동합니다.");
            req.setAttribute("url", "member_index.do");
        }else {
            req.setAttribute("msg", "회원삭제 실패!! 회원관리페이지로 이동합니다.");
            req.setAttribute("url", "member_index.do");
        }
        return "/message";
    }

    @RequestMapping(value="/member_update.do", method= RequestMethod.GET)
    public String member_update(HttpServletRequest req, int no) {
        MemberDTO dto = memberDAO.getMember(no);
        req.setAttribute("dto", dto);
        return "/member/member_update";
    }

    @RequestMapping(value="/member_update.do", method=RequestMethod.POST)
    public String member_update_ok(HttpServletRequest req, MemberDTO dto) {
        int res = memberDAO.updateMember(dto);
        if (res>0) {
            req.setAttribute("msg", "회원수정 성공!! 회원관리페이지로 이동합니다.");
            req.setAttribute("url", "member_index.do");
        }else {
            req.setAttribute("msg", "회원수정 실패!! 회원수정페이지로 이동합니다.");
            req.setAttribute("url", "member_update.do?no="+dto.getNo());
        }
        return "/message";
    }
}
