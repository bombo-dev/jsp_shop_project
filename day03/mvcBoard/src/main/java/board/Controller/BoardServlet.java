package board.Controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class BoardServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html; charset=utf-8");

        String url = req.getRequestURI();
        String upPath = req.getContextPath();
        String cmd = url.substring(upPath.length());

        CommandFactory factory = CommandFactory.getInstance();
        CommandIf cmdIf = factory.createCommand(cmd);
        // RequestDispatcher rd = req.getRequestDispatcher("list.jsp");
        // rd.forward(req, resp);

    }
}
