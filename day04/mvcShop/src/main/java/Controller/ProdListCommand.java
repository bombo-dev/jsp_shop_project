package Controller;

import DAO.ProductDAO;
import DAO.ProductDAOImpl;
import DTO.ProductDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ProdListCommand implements CommandIf{
    @Override
    public Object processCommand(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductDAO dao = new ProductDAOImpl();
        List<ProductDTO> list = dao.listProd();
        req.setAttribute("listProd", list);
        req.setAttribute("upPath", req.getServletContext().getRealPath("prodImage"));
        return "WEB-INF/admin/prod_list.jsp";
    }
}
