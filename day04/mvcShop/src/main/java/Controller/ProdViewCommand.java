package Controller;

import DAO.ProductDAO;
import DAO.ProductDAOImpl;
import DTO.ProductDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ProdViewCommand implements CommandIf{
    @Override
    public Object processCommand(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        ProductDAO dao = new ProductDAOImpl();

        String pnum = req.getParameter("pnum");
        ProductDTO dto = dao.viewProd(Integer.parseInt(pnum));
        req.setAttribute("dto", dto);
        req.setAttribute("upPath", req.getServletContext().getRealPath("prodImage"));

        return "WEB-INF/admin/prod_view.jsp";
    }
}
