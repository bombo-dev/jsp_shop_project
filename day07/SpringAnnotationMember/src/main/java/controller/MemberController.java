package controller;

import dao.MemberDAO;
import dto.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class MemberController {

    @Autowired
    private MemberDAO memberDAO;

    @RequestMapping("memberAll.do")
    public String memberAll(HttpServletRequest req, MemberDTO dto, String mode){
        if(mode == null){
            mode = "all";
        }

        List<MemberDTO> list;

        if (mode.equals("all")) list = memberDAO.listMember();
        else list = memberDAO.findMember(dto);

        req.setAttribute("list", list);

        return "/member/member_list";
    }
}
