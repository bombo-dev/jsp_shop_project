package member.controller;

import member.dto.MemberDTO;
import member.resource.MemberMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MemberController {
    @RequestMapping("member_index.do")
    public String memberIndex() {
        return "/member/index";
    }

    @RequestMapping("memberAll.do")
    public String memberAll(HttpServletRequest req) {
        List<MemberDTO> list = MemberMapper.listMember();
        req.setAttribute("listMember", list);
        return "/member/memberAll";
    }

    @RequestMapping("memberSsn.do")
    public String memberSsn() {
        return "/member/memberSsn";
    }

    @RequestMapping("member_check.do")
    public String memberCheck(HttpServletRequest req, @RequestParam Map<String, String> params){
        Map<String, Object>map = new HashMap<>();

        map.put("ssn1", params.get("ssn1"));
        map.put("ssn2", params.get("ssn2"));

        boolean isMember = MemberMapper.checkMember(map);
        if (isMember) {
            req.setAttribute("msg", "이미 게정이 존재합니다. 첫 페이지로 돌아갑니다.!!");
            req.setAttribute("url", "member_index.do");
        }else {
            return "/member/member_input";
        }
        return "/message";
    }

    @RequestMapping("member_input_ok.do")
    public String memberInput(HttpServletRequest req, MemberDTO dto){
        int res = MemberMapper.insertMember(dto);
        if (res>0) {
            req.setAttribute("msg", "멤버 등록에 성공하였습니다. 초기 페이지로 돌아갑니다..");
            req.setAttribute("url", "member_index.do");
        }else {
            req.setAttribute("msg", "멤버 등록에 실패하였습니다. 검증 페이지로 돌아갑니다.");
            req.setAttribute("url", "memberSsn.do");
        }
        return "/message";
    }

    @RequestMapping("member_delete.do")
    public String memberDelete(HttpServletRequest req, int no) {
        int res = MemberMapper.deleteMember(no);

        if (res>0) {
            req.setAttribute("msg", "회원삭제 성공!! 회원관리페이지로 이동합니다.");
            req.setAttribute("url", "member_index.do");
        }else {
            req.setAttribute("msg", "회원삭제 실패!! 회원관리페이지로 이동합니다.");
            req.setAttribute("url", "member_index.do");
        }
        return "/message";
    }

    @RequestMapping(value = "member_update.do", method= RequestMethod.GET)
    public String memberUpdate(HttpServletRequest req, int no){
        MemberDTO dto = MemberMapper.getMember(no);
        req.setAttribute("getMember", dto);
        return "/member/member_update";
    }

    @RequestMapping(value="member_update.do", method=RequestMethod.POST)
    public String memberUpdateOK(HttpServletRequest req, MemberDTO dto){
        int res = MemberMapper.updateMember(dto);
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
