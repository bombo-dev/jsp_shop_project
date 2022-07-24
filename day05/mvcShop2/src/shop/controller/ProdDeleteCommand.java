package shop.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.dao.ProductDAO;

public class ProdDeleteCommand implements CommandIf {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String pnum = req.getParameter("pnum");
		String pimage = req.getParameter("pimage");
		ProductDAO dao = new ProductDAO();
		int res = dao.deleteProd(Integer.parseInt(pnum));
		if (res>0) {
			String upPath = req.getServletContext().getRealPath("prodImage");
			File file = new File(upPath, pimage);
			if (file.delete()) {
				req.setAttribute("msg", "상품삭제 성공!! 상품목록으로 이동합니다.");
			}else {
				req.setAttribute("msg", "상품삭제 성공(이미지삭제는 실패)!! 상품목록으로 이동합니다.");
			}
		}else {
			req.setAttribute("msg", "상품삭제 실패!! 상품목록으로 이동합니다.");
		}
		req.setAttribute("url", "prod_list.mall");
		return "message.jsp";
	}

}
