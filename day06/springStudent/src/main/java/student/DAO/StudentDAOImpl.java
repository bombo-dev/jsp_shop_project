package student.DAO;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import student.DTO.StudentDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class StudentDAOImpl implements StudentDAO{

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    class MyRowMapper implements RowMapper<StudentDTO> {
        @Override
        public StudentDTO mapRow(ResultSet rs, int i) throws SQLException {
            StudentDTO dto = new StudentDTO();
            dto.setId(rs.getString("id"));
            dto.setName(rs.getString("name"));
            dto.setCname(rs.getString("cname"));
            return dto;
        }
    }

    @Override
    public List<StudentDTO> listStudent() {
        String sql = "SELECT * FROM STUDENT";
        MyRowMapper mapper = new MyRowMapper();
        List<StudentDTO> list = jdbcTemplate.query(sql, mapper);
        return list;
    }

    @Override
    public int insertStudent(StudentDTO dto) {
        String sql = "INSERT INTO STUDENT VALUES(?, ?, ?)";
        Object[] values = new Object[] {dto.getId(), dto.getName(), dto.getCname()};
        int res = jdbcTemplate.update(sql, values);
        //update : insert, delete, update시 사용
        //query : List타입으로 결과를 받아올 때
        //queryForObject : DTO 값을 결과로 받아올 때
        //queryForInt : count, max, min, ... 정수형태의 결과를 받아올 때
        return res;
    }

    @Override
    public StudentDTO findStudent(String name) {
        String sql = "SELECT * FROM STUDENT WHERE NAME = ?";
        MyRowMapper mapper = new MyRowMapper();
        List<StudentDTO> list = jdbcTemplate.query(sql, mapper, name);
        return list.get(0);
    }

    @Override
    public int deleteStudent(String id) {
        String sql = "DELETE FROM STUDENT WHERE id = ?";
        int res = jdbcTemplate.update(sql, id);
        return res;
    }
}
