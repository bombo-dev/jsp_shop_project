package shop.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.dao.ProductDAO;
import shop.dto.ProductDTO;

public class ProdListCommand implements CommandIf {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		ProductDAO dao = new ProductDAO();
		List<ProductDTO> list = dao.listProd();
		req.setAttribute("listProd", list);
		req.setAttribute("upPath", req.getServletContext().getRealPath("prodImage"));
		return "WEB-INF/admin/prod_list.jsp";
	}

}








