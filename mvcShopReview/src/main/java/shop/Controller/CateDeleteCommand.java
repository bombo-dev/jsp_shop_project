package shop.Controller;

import shop.DAO.CategoryDAO;
import shop.DAO.CategoryDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CateDeleteCommand implements CommandIf {

    @Override
    public Object processCommand(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String cnum = req.getParameter("cnum");

        CategoryDAO dao = new CategoryDAOImpl();
        int res = dao.categoryDelete(Integer.parseInt(cnum));

        if(res > 0){
            String msg = "삭제에 성공하였습니다. 카테고리 목록 페이지로 이동합니다.";
            String url = "cate_list.do";
            req.setAttribute("msg", msg);
            req.setAttribute("url", url);
        } else {
            String msg = "삭제에 실패하였습니다. 카테고리 목록 페이지로 이동합니다.";
            String url = "cate_list.do";
            req.setAttribute("msg", msg);
            req.setAttribute("url", url);
        }
        return "message.jsp";
    }
}
