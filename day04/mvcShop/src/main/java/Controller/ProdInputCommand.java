package Controller;

import DAO.CategoryDAO;
import DAO.CategoryDAOImpl;
import DTO.CategoryDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ProdInputCommand implements CommandIf{
    @Override
    public Object processCommand(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        CategoryDTO dto = new CategoryDTO();
        CategoryDAO dao= new CategoryDAOImpl();
        List<CategoryDTO> list = dao.categoryList();
        req.setAttribute("categoryList", list);

        return "WEB-INF/admin/prod_input.jsp";
    }
}
