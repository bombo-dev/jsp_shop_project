package shop.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface CommandIf {
    Object processCommand(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
}
