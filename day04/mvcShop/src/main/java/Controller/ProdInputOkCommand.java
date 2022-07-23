package Controller;

import DAO.ProductDAO;
import DAO.ProductDAOImpl;
import com.oreilly.servlet.MultipartRequest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ProdInputOkCommand implements CommandIf{
    @Override
    public Object processCommand(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MultipartRequest mr = null;
        String upPath = req.getServletContext().getRealPath("prodImage");
        int len = 10*1024*1024;
        try {
            mr = new MultipartRequest(req, upPath, len, "utf-8");
            ProductDAO dao = new ProductDAOImpl();
            int res = dao.insertProd(mr);
            if (res>0) {
                req.setAttribute("msg", "상품등록 성공!! 상품 목록 페이지로 이동합니다.");
                req.setAttribute("url", "prod_list.do");
            }else {
                req.setAttribute("msg", "상품등록 실패!! 상품 등록 페이지로 이동합니다.");
                req.setAttribute("url", "prod_input.do");
            }
        }catch(IOException e) {
            req.setAttribute("msg", "상품 등록 실패!! 관리자 페이지로 이동합니다.");
            req.setAttribute("url", "adminShop.do");
        }

        return "message.jsp";
    }
}
