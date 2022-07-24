package shop.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.dao.CategoryDAO;
import shop.dao.ProductDAO;
import shop.dto.CategoryDTO;
import shop.dto.ProductDTO;

public class ShopMainCommand implements CommandIf {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		CategoryDAO dao = new CategoryDAO();
		List<CategoryDTO> list = dao.listCate();
		if (list == null || list.size()==0) {
			req.setAttribute("msg", "ºÓ«Œ∏Ù ¡ÿ∫Ò¡ﬂ ¿‘¥œ¥Ÿ.");
			req.setAttribute("url", "index.mall");
			return "message.jsp";
		}
		HttpSession session = req.getSession();
		session.setAttribute("listCate", list);
		ProductDAO pdao = new ProductDAO();
		List<ProductDTO> list1 = pdao.selectBySpec("HIT");
		List<ProductDTO> list2 = pdao.selectBySpec("NEW");
		List<ProductDTO> list3 = pdao.selectBySpec("BEST");
		session.setAttribute("HIT", list1);
		session.setAttribute("NEW", list2);
		session.setAttribute("BEST", list3);
		return "WEB-INF/display/mall.jsp";
	}

}











