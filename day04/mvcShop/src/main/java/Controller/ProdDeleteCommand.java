package Controller;

import DAO.ProductDAO;
import DAO.ProductDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

public class ProdDeleteCommand implements CommandIf{
    @Override
    public Object processCommand(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String pnum = req.getParameter("pnum");
        String pimage = req.getParameter("pimage");
        ProductDAO dao = new ProductDAOImpl();
        int res = dao.deleteProd(Integer.parseInt(pnum));
        if (res>0) {
            String upPath = req.getServletContext().getRealPath("prodImage");
            File file = new File(upPath, pimage);
            if (file.delete()) {
                req.setAttribute("msg", "상품 삭제가 완료되었습니다. 상품목록 페이지로 이동합니다.");
            }else {
                req.setAttribute("msg", "상품 삭제를 성공하였습니다.!! (이미지 삭제는 실패하였습니다.) 상품목록 페이지로 이동합니다.");
            }
        }else {
            req.setAttribute("msg", "상품 삭제 실패. 상품목록 페이지로 이동합니다.");
        }
        req.setAttribute("url", "prod_list.do");
        return "message.jsp";
    }
}
