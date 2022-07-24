package shop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.dao.ProductDAO;
import shop.dto.ProductDTO;

public class ProdViewCommand implements CommandIf {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String pnum = req.getParameter("pnum");
		ProductDAO dao = new ProductDAO();
		ProductDTO dto = dao.getProduct(Integer.parseInt(pnum));
		req.setAttribute("getProd", dto);
		req.setAttribute("upPath", req.getServletContext().getRealPath("prodImage"));
		return "WEB-INF/admin/prod_view.jsp";
	}

}
