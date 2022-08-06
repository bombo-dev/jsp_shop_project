package shop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import shop.dao.ProductDAO;

public class ProdInputOkCommand implements CommandIf {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		MultipartRequest mr = null;
		String upPath = req.getServletContext().getRealPath("prodImage");
		int len = 10*1024*1024;
		try {
			mr = new MultipartRequest(req, upPath, len, "EUC-KR");
			ProductDAO dao = new ProductDAO();
			int res = dao.insertProd(mr);
			if (res>0) {
				req.setAttribute("msg", "��ǰ��ϼ���!! ��ǰ����������� �̵��մϴ�");
				req.setAttribute("url", "prod_list.mall");
			}else {
				req.setAttribute("msg", "��ǰ��Ͻ���!! ��ǰ����������� �̵��մϴ�");
				req.setAttribute("url", "prod_input.mall");
			}
		}catch(IOException e) {
			req.setAttribute("msg", "���� ���ε�� ���� �߻�!!");
			req.setAttribute("url", "adminShop.mall");
		}
		
		return "message.jsp";
	}

}