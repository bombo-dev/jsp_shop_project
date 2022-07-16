package Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class StudentServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html; charset=utf-8");
        String cmd = req.getParameter("command");
        CommandFactory factory = CommandFactory.getInstance();
        CommandIf cmdIf = factory.createCommand(cmd);

        String nextPage = cmdIf.processCommand(req, resp);
        RequestDispatcher rd = req.getRequestDispatcher(nextPage);
        rd.forward(req, resp);
    }
}
