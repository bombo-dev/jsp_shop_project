package Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FindCommand implements CommandIf {
    @Override
    public String processCommand(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StudentDTO dto = new StudentDTO();
        dto.setName(req.getParameter("name"));

        StudentDAO dao = new StudentDAO();
        dto = dao.selectOne(dto);

        String msg = null, url = null;
        if (dto != null){
            msg = "학생 검색을 성공하였습니다. 학생 찾기 페이지로 이동합니다.";
            url = "student.do?command=find";
            req.setAttribute("findStudent", dto);
            RequestDispatcher rd = req.getRequestDispatcher("find.jsp");
            rd.forward(req, resp);
        }else {
            msg = "학생 검색을 실패하였습니다. 학생 관리 페이지로 이동합니다.";
            url = "student.do?command=index";
        }
        req.setAttribute("msg", msg);
        req.setAttribute("url", url);

        return "find.jsp";
    }
}
