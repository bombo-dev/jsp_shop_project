package student.DAO;

import student.DTO.StudentDTO;

import java.util.List;

public interface StudentDAO {
    List<StudentDTO> listStudent();
    int insertStudent(StudentDTO dto);
    StudentDTO getStudent(String name);
    int delete(String id);
}
