package shop.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.dao.CartDAO;
import shop.dto.ProductDTO;

public class MallCardAddCommand implements CommandIf {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String pnum = req.getParameter("pnum");
		String select = req.getParameter("select");
		String qty = req.getParameter("qty");
		
		CartDAO dao =  CartDAO.getInstance();
		HttpSession session = req.getSession();
		List<ProductDTO> list = (List)session.getAttribute(select);
		for(ProductDTO dto : list) {
			if (dto.getPnum() == Integer.parseInt(pnum)) {
				dto.setPqty(Integer.parseInt(qty));
				dao.addCart(dto);
				break;
			}
		}
		return "cartList.mall";
	}
}
