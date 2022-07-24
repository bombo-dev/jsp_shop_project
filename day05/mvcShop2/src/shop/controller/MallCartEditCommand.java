package shop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.dao.CartDAO;

public class MallCartEditCommand implements CommandIf {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String pnum = req.getParameter("pnum");
		String qty = req.getParameter("qty");
		CartDAO dao = CartDAO.getInstance();
		dao.editCart(Integer.parseInt(pnum), Integer.parseInt(qty));
		return "cartList.mall";
	}

}
