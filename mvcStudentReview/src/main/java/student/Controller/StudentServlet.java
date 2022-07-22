package student.Controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class StudentServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html; charset=utf-8");

        String url = req.getRequestURI();
        String upPath = req.getContextPath();
        String cmd = url.substring(upPath.length());

        System.out.println("cmd : " + cmd);

        CommandFactory factory = CommandFactory.getInstance();
        CommandIf cmdIf = factory.createCommand(cmd);

        String nextPage = (String)cmdIf.processCommand(req, resp);

        System.out.println("nextPage : " + nextPage);

        RequestDispatcher rd = req.getRequestDispatcher(nextPage);
        rd.forward(req, resp);
    }
}
