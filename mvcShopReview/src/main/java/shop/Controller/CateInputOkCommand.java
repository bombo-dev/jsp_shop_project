package shop.Controller;

import shop.DAO.CategoryDAO;
import shop.DAO.CategoryDAOImpl;
import shop.DTO.CategoryDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CateInputOkCommand implements CommandIf{
    @Override
    public Object processCommand(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        CategoryDTO dto = new CategoryDTO();
        dto.setCode(req.getParameter("code"));
        dto.setCname(req.getParameter("cname"));

        CategoryDAO dao = new CategoryDAOImpl();
        int res = dao.categoryInsert(dto);

        if(res > 0){
            String msg = "등록에 성공하였습니다. 카테고리 목록 페이지로 이동합니다.";
            String url = "cate_list.do";
            req.setAttribute("msg", msg);
            req.setAttribute("url", url);
        } else {
            String msg = "등록에 실패하였습니다. 카테고리 등록 페이지로 이동합니다.";
            String url = "cate_input.do";
            req.setAttribute("msg", msg);
            req.setAttribute("url", url);
        }
        return "message.jsp";
    }
}
