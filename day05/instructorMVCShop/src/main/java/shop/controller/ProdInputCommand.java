package shop.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.dao.CategoryDAO;
import shop.dto.CategoryDTO;

public class ProdInputCommand implements CommandIf {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		CategoryDAO dao = new CategoryDAO();
		List<CategoryDTO> list = dao.listCate();
		if (list == null || list.size()==0) {
			return "WEB-INF/admin/cate_input.jsp";
		}
		req.setAttribute("listCate", list);
		return "WEB-INF/admin/prod_input.jsp";
	}

}








