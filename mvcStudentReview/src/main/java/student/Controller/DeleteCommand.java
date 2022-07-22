package student.Controller;

import student.DAO.StudentDAO;
import student.DAO.StudentDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteCommand implements CommandIf{
    @Override
    public Object processCommand(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String msg = "";
        String url = "";
        String id = req.getParameter("id");
        StudentDAO dao = new StudentDAOImpl();

        int res = dao.delete(id);

        if(res != 0){
            msg = "삭제가 완료되었습니다. 학생 목록 페이지로 이동합니다.";
            url = "student_list.do";
        } else {
            msg = "삭제를 실패하였습니다. 학생 관리 페이지로 이동합니다.";
            url = "student_manage.do";
        }

        req.setAttribute("msg", msg);
        req.setAttribute("url", url);

        return "message.jsp";
    }
}
