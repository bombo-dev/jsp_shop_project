package shop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.dao.CategoryDAO;
import shop.dto.CategoryDTO;

public class CateInputOkCommand implements CommandIf {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		CategoryDTO dto = new CategoryDTO();
		dto.setCode(req.getParameter("code"));
		dto.setCname(req.getParameter("cname"));
		CategoryDAO dao = new CategoryDAO();
		int res = dao.insertCate(dto);
		if (res>0) {
			req.setAttribute("msg", "ī�װ� ��� ����!! ī�װ� ��� �������� �̵��մϴ�.");
			req.setAttribute("url", "cate_list.mall");
		}else {
			req.setAttribute("msg", "ī�װ� ��� ����!! ī�װ� ��� �������� �̵��մϴ�.");
			req.setAttribute("url", "cate_input.mall");
		}
		return "message.jsp";
	}

}
