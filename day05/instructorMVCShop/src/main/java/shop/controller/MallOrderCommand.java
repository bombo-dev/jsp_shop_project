package shop.controller;

import shop.dao.CartDAO;
import shop.dto.ProductDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class MallOrderCommand implements CommandIf {

    @Override
    public Object processCommand(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String mode = req.getParameter("mode");
        HttpSession session = req.getSession();

        System.out.println("mode " + mode);
        if (mode == null){
            System.out.println("if문 진입");
            CartDAO dao =  CartDAO.getInstance();
            List<ProductDTO> list = dao.listCart();

            req.setAttribute("prodBuyList", list);
        } else{
            String pnum = req.getParameter("pnum");
            String select = req.getParameter("select");
            List<ProductDTO> list = (List)session.getAttribute(select);

            for (ProductDTO dto : list) {
                if (dto.getPnum() == Integer.parseInt(pnum)) {
                    req.setAttribute("prodBuy", dto);
                    break;
                }
            }
        }
        return "WEB-INF/display/mall_receipt.jsp";
    }
}
