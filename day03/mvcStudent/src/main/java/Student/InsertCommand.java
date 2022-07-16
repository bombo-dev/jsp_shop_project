package Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class InsertCommand extends HttpServlet implements CommandIf{

    @Override
    public String processCommand(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StudentDTO dto = new StudentDTO();
        dto.setId(req.getParameter("id"));
        dto.setName(req.getParameter("name"));
        dto.setCname(req.getParameter("cname"));
        StudentDAO dao = new StudentDAO();
        int res = dao.insertStudent(dto);
        String msg = null, url = null;
        if (res > 0){
            msg = "학생 등록을 성공하였습니다. 학생 목록 페이지로 이동합니다.";
            url = "student.do?command=list";
        }else {
            msg = "학생 등록을 실패하였습니다. 학생 관리 페이지로 이동합니다.";
            url = "student.do?command=index";
        }
        req.setAttribute("msg", msg);
        req.setAttribute("url", url);

        return "message.jsp";
    }
}
