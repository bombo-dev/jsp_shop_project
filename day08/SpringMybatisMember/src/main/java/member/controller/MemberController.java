package member.controller;

import member.dto.MemberDTO;
import member.resource.MemberMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MemberController {

    public static final int OK = 0;
    public static final int NOT_ID = 1;
    public static final int NOT_PWD = 2;
    public static final int ERROR = -1;

    @RequestMapping("member_index.do")
    public String memberIndex(HttpServletRequest req, HttpSession session) {
        boolean isLogin = false;
        String mbId = (String)session.getAttribute("mbId");
        if (mbId != null){
            isLogin = true;
        }
        session.setAttribute("isLogin", isLogin);

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

    @RequestMapping(value="login.do", method = RequestMethod.GET)
    public String memberLogin(HttpServletRequest req){

        Cookie[] cks = req.getCookies();
        String value = null;
        if (cks != null || cks.length != 0){
            for(int i=0; i<cks.length; ++i){
                String name = cks[i].getName();
                if (name.equals("saveId")){
                    value = cks[i].getValue();
                    break;
                }
            }
        }
        req.setAttribute("value", value);

        return "/member/login";
    }

    @RequestMapping(value="login.do", method = RequestMethod.POST)
    public String memberLoginOk(HttpServletRequest req, HttpServletResponse resp, HttpSession session, @RequestParam String id){

        String value = (String)req.getAttribute("value");
        Cookie ck;
        if(value != null) {
            ck = new Cookie("saveId", id);
        } else {
            ck = new Cookie("null", "");
        }

        int res = MemberMapper.checkLogin(id);

        MemberDTO dto = MemberMapper.getMemberId(id);
        String dbPass = dto.getPasswd();
        if(res != -1) {
            if (Integer.parseInt(dbPass) == res) {
                if (id != null)
                    ck.setMaxAge(24 * 60 * 60);
                else
                    ck.setMaxAge(0);

                resp.addCookie(ck);
                session.setAttribute("mbId", id);

                req.setAttribute("msg", "로그인이 되었습니다.");
                req.setAttribute("url", "member_index.do");
            }
            else{
                req.setAttribute("msg", "비밀번호가 틀렸습니다. 다시 입력해주세요.");
                req.setAttribute("url", "login.do");
            }
        } else {
            req.setAttribute("msg", "없는 아이디 입니다. 다시 로그인을 해주세요.");
            req.setAttribute("url", "login.do");
        }

        return "/message";
    }

    @RequestMapping("logout.do")
    public String memberLogout(HttpServletRequest req, HttpSession session){
        session.invalidate();

        req.setAttribute("msg", "로그아웃 되었습니다.");
        req.setAttribute("url", "member_index.do");

        return "/message";
    }
}
