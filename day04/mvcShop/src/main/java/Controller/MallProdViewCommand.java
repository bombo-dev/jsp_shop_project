package Controller;

import DAO.MallDAO;
import DAO.MallDAOImpl;
import DAO.ProductDAO;
import DAO.ProductDAOImpl;
import DTO.ProductDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class MallProdViewCommand implements CommandIf{
    @Override
    public Object processCommand(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pnum = req.getParameter("pnum");
        String pspec = req.getParameter("select");

        HttpSession session = req.getSession();
        ProductDAO dao = new ProductDAOImpl();
        if(pspec != null && !(pspec.trim().equals(""))) {
            List<ProductDTO> list = (List) session.getAttribute(pspec);

            for (ProductDTO dto : list) {
                if (dto.getPnum() == Integer.parseInt(pnum)) {
                    req.setAttribute("dto", dto);
                }
            }
        } else {
            ProductDTO dto = dao.viewProd(Integer.parseInt(pnum));
            req.setAttribute("dto", dto);
        }

        return "WEB-INF/user/ProdDetail.jsp";
    }
}
