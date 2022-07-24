package shop.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.dao.CartDAO;
import shop.dto.ProductDTO;

public class MallOrderCommand implements CommandIf {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String mode = req.getParameter("mode");
		List<ProductDTO> list = null;
		if (mode==null) {
			CartDAO dao = CartDAO.getInstance();
			list = dao.listCart();
			//dao.deleteAllCart();
		}else {
			String pnum = req.getParameter("pnum");
			String select = req.getParameter("select");
			String qty = req.getParameter("qty");
			HttpSession session = req.getSession();
			List<ProductDTO> list2 = (List)session.getAttribute(select);
			list = new ArrayList<>();
			for(ProductDTO dto : list2) {
				if (dto.getPnum() == Integer.parseInt(pnum)) {
					dto.setPqty(Integer.parseInt(qty));
					list.add(dto);
					break;
				}
			}
		}
		req.setAttribute("order", list);
		return "WEB-INF/display/mall_order.jsp";
	}

}
