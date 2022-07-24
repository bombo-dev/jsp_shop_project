package shop.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.dto.ProductDTO;

public class ProdViewMallCommand implements CommandIf {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String pnum = req.getParameter("pnum");
		String select = req.getParameter("select");
		HttpSession session = req.getSession();
		List<ProductDTO> list = (List)session.getAttribute(select);
		for(ProductDTO dto : list) {
			if (dto.getPnum() == Integer.parseInt(pnum)) {
				req.setAttribute("getProd", dto);
			}
		}
		return "WEB-INF/display/mall_prodView.jsp";
	}

}
