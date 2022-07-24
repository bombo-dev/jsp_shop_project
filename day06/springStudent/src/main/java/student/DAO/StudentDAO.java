package student.DAO;

import student.DTO.StudentDTO;

import java.util.List;

public interface StudentDAO {
    List<StudentDTO> listStudent();
    int insertStudent(StudentDTO dto);
    StudentDTO findStudent(String name);
    int deleteStudent(String id);
}
