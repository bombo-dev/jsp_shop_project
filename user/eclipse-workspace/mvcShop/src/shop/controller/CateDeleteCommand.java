package shop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.dao.CategoryDAO;

public class CateDeleteCommand implements CommandIf {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String cnum = req.getParameter("cnum");
		CategoryDAO dao = new CategoryDAO();
		int res = dao.deleteCate(Integer.parseInt(cnum));
		if (res>0) {
			req.setAttribute("msg", "ī�װ� ���� ����!! ī�װ� ��� �������� �̵��մϴ�.");
			req.setAttribute("url", "cate_list.mall");
		}else {
			req.setAttribute("msg", "ī�װ� ���� ����!! ī�װ� ��� �������� �̵��մϴ�.");
			req.setAttribute("url", "cate_list.mall");
		}
		return "message.jsp";
	}

}
