package Controller;

import DAO.CategoryDAO;
import DAO.CategoryDAOImpl;
import DAO.MallDAO;
import DAO.MallDAOImpl;
import DTO.CategoryDTO;
import DTO.ProductDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class MallCommand implements CommandIf{
    @Override
    public Object processCommand(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        CategoryDAO cateDao = new CategoryDAOImpl();
        List<CategoryDTO> cateList = cateDao.categoryList();
        if (cateList == null || cateList.size()==0) {
            req.setAttribute("msg", "쇼핑몰 준비중 입니다.");
            req.setAttribute("url", "index.do");
            return "message.jsp";
        }

        HttpSession session = req.getSession();

        MallDAO mallDao = new MallDAOImpl();
        List<ProductDTO> hitList = mallDao.hitProductView();
        List<ProductDTO> newList = mallDao.newProductView();
        List<ProductDTO> bestList = mallDao.bestProductView();

        session.setAttribute("categoryList", cateList);
        session.setAttribute("HIT", hitList);
        session.setAttribute("NEW", newList);
        session.setAttribute("BEST", bestList);

        return "WEB-INF/user/mall.jsp";
    }
}
