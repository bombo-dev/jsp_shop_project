package student;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexCommand implements CommandIf{

	@Override
	public String processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		return "index.jsp";
	}

}
