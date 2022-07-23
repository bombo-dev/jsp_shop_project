package Controller;

import DAO.ProductDAO;
import DAO.ProductDAOImpl;
import DTO.ProductDTO;
import com.oreilly.servlet.MultipartRequest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ProdUpdateOkCommand implements CommandIf{
    @Override
    public Object processCommand(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        MultipartRequest mr = null;
        String upPath = req.getServletContext().getRealPath("prodImage");
        int len = 10*1024*1024;
        try {
            mr = new MultipartRequest(req, upPath, len, "utf-8");
            ProductDAO dao = new ProductDAOImpl();
            int res = dao.updateProd(mr);
            if (res>0) {
                req.setAttribute("msg", "상품수정성공!! 상품목록페이지로 이동합니다");
                req.setAttribute("url", "prod_list.do");
            }else {
                req.setAttribute("msg", "상품수정실패!! 상품등록페이지로 이동합니다");
                req.setAttribute("url", "prod_update.do?pnum=" + mr.getParameter("pnum"));
            }
        }catch(IOException e) {
            req.setAttribute("msg", "파일 업로드시 오류 발생!!");
            req.setAttribute("url", "adminShop.do");
        }

        return "message.jsp";
    }
}
