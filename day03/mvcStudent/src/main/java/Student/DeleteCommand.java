package Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteCommand implements CommandIf{
    @Override
    public String processCommand(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StudentDTO dto = new StudentDTO();
        dto.setId(req.getParameter("id"));
        StudentDAO dao = new StudentDAO();
        int res = dao.delete(dto);
        String msg = null, url = null;
        if (res > 0){
            msg = "학생 삭제를 성공하였습니다. 학생 목록 페이지로 이동합니다.";
            url = "student.do?command=list";
        }else {
            msg = "학생 삭제를 실패하였습니다. 학생 관리 페이지로 이동합니다.";
            url = "student.do?command=index";
        }
        req.setAttribute("msg", msg);
        req.setAttribute("url", url);

        return "message.jsp";
    }
}
