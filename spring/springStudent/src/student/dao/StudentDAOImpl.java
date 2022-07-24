package student.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import student.dto.StudentDTO;

public class StudentDAOImpl implements StudentDAO {
	private JdbcTemplate jdbcTemplate;
		
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	class MyRowMapper implements RowMapper<StudentDTO>{
		@Override
		public StudentDTO mapRow(ResultSet rs, int arg1) throws SQLException {
			StudentDTO dto = new StudentDTO();
			dto.setId(rs.getString("id"));
			dto.setName(rs.getString("name"));
			dto.setCname(rs.getString("cname"));
			return dto;
		}
	}
	
	@Override
	public int insertStudent(StudentDTO dto) {
		String sql = "insert into student values(?, ?, ?)";
		Object[] values = new Object[] 
				{dto.getId(), dto.getName(), dto.getCname()};
		int res = jdbcTemplate.update(sql, values);
		//update : insert, delete, update시 사용
		//query : List타입으로 결과를 받아올때
		//queryForObject : DTO값을 결과로 받아올때
		//queryForInt : count, max, min ... 정수형태의 결과를 받아올때
		return res;
	}

	@Override
	public int deleteStudent(String id) {
		String sql = "delete from student where id = ?";
		int res = jdbcTemplate.update(sql, id);
		return res;
	}

	@Override
	public List<StudentDTO> findStudent(String name) {
		String sql = "select * from student where name = ?";
		MyRowMapper mapper = new MyRowMapper();		
		List<StudentDTO> list = jdbcTemplate.query(sql, mapper, name);
		return list;
	}

	@Override
	public List<StudentDTO> listStudent() {
		String sql = "select * from student";
		MyRowMapper mapper = new MyRowMapper();		
		List<StudentDTO> list = jdbcTemplate.query(sql, mapper);
		return list;
	}

}
