package shop.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.dao.CartDAO;
import shop.dto.ProductDTO;

public class MallCartListCommand implements CommandIf {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		CartDAO dao = CartDAO.getInstance();
		List<ProductDTO> cart = dao.listCart();
		req.setAttribute("cart", cart);
		return "WEB-INF/display/mall_cartList.jsp";
	}

}
