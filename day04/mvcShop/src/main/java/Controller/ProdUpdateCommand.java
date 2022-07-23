package Controller;

import DAO.ProductDAO;
import DAO.ProductDAOImpl;
import DTO.ProductDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ProdUpdateCommand implements CommandIf{
    @Override
    public Object processCommand(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String pnum = req.getParameter("pnum");
        ProductDAO dao = new ProductDAOImpl();
        ProductDTO dto = dao.viewProd(Integer.parseInt(pnum));
        String upPath = req.getServletContext().getRealPath("prodImage");

        req.setAttribute("dto", dto);
        req.setAttribute("upPath", upPath);
        return "WEB-INF/admin/prod_update.jsp";
    }
}
