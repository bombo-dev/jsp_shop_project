package shop.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.dao.ProductDAO;
import shop.dto.CategoryDTO;
import shop.dto.ProductDTO;

public class CgProdListCommand implements CommandIf {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String code = req.getParameter("code");
		String cname = null;
		HttpSession session = req.getSession();
		List<CategoryDTO> list = (List)session.getAttribute("listCate");
		for (CategoryDTO dto : list) {
			if (dto.getCode().equals(code)) {
				cname = dto.getCname();
				break;
			}
		}
		req.setAttribute("code", code);
		req.setAttribute("cname", cname);
		ProductDAO dao = new ProductDAO();
		List<ProductDTO> plist = dao.selectByCode(code);
		session.setAttribute(code, plist);
		return "WEB-INF/display/mall_cgProdList.jsp";
	}

}
