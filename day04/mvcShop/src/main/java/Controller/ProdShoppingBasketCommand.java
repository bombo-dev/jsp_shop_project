package Controller;

import DAO.ProductDAO;
import DAO.ProductDAOImpl;
import DTO.ProductDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProdShoppingBasketCommand implements CommandIf{
    @Override
    public Object processCommand(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pnum = req.getParameter("pnum");
//        String pspec = req.getParameter("select");
        ProductDAO dao = new ProductDAOImpl();

        ProductDTO cartDto = dao.viewProd(Integer.parseInt(pnum));

        HttpSession session = req.getSession();
        List<ProductDTO> basketList;

        if((List<ProductDTO>)session.getAttribute("basketList") == null) {
            basketList = new ArrayList<>();
            System.out.println("실행1");
        } else {
            basketList = (List<ProductDTO>) session.getAttribute("basketList");
            System.out.println("실행2");
        }

        basketList.add(cartDto);

        for(ProductDTO dto : basketList){
            System.out.println("dto : " +dto.getPnum());
        }

        session.setAttribute("basketList", basketList);

        return "WEB-INF/user/cartList.jsp";
    }
}
