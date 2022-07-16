package mvc1;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

// 2번
public class DepartServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        String depart = req.getParameter("depart");
        // PrintWriter pw = resp.getWriter();
        // pw.println("넘어온 데이터 : " + depart);
        // 3번
        DepartExpert de = new DepartExpert();
        // 4번
        List<String> advice = de.getAdvice(depart);
        // 5번
        req.setAttribute("advice", advice);
        // 6번
        RequestDispatcher rd = req.getRequestDispatcher("result.jsp");

        rd.forward(req, resp);
    }
}
