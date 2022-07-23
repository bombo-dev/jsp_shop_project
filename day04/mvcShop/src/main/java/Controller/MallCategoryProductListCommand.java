package Controller;

import DAO.MallDAO;
import DAO.MallDAOImpl;
import DTO.ProductDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class MallCategoryProductListCommand implements CommandIf{
    @Override
    public Object processCommand(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String code = req.getParameter("code");
        String cname = req.getParameter("cname");

        MallDAO dao = new MallDAOImpl();
        List<ProductDTO> list = dao.categoryProductView(code);

        req.setAttribute("cateSearchList", list);
        req.setAttribute("cname", cname);

        return "WEB-INF/user/cgProdList.jsp";
    }
}
