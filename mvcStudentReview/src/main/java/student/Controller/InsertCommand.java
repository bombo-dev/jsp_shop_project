package student.Controller;

import student.DAO.StudentDAO;
import student.DAO.StudentDAOImpl;
import student.DTO.StudentDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class InsertCommand implements CommandIf{
    @Override
    public Object processCommand(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String msg = "";
        String url = "";

        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String cname = req.getParameter("cname");

        StudentDTO dto = new StudentDTO();
        dto.setId(id);
        dto.setName(name);
        dto.setCname(cname);

        StudentDAO dao = new StudentDAOImpl();
        int res = dao.insertStudent(dto);

        if(res != 0){
            msg = "등록이 완료되었습니다. 학생 목록 페이지로 이동합니다.";
            url = "student_list.do";
        } else {
            msg = "등록을 실패하였습니다. 학생 관리 페이지로 이동합니다.";
            url = "student_manage.do";
        }

        req.setAttribute("msg", msg);
        req.setAttribute("url", url);


        return "message.jsp";
    }
}
