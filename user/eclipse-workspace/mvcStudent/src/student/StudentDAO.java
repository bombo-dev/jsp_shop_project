package student;
import java.sql.*;
import java.util.*;

import javax.naming.*;
import javax.sql.*;

public class StudentDAO {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	static DataSource ds;
	static {
		try {
			Context init = new InitialContext();
			ds = (DataSource)init.lookup("java:/comp/env/jdbc/oracleXE");
		}catch(NamingException e) {
			e.printStackTrace();
		}
	}
	
	protected List<StudentDTO> makeList(ResultSet rs) 
									throws SQLException{
		List<StudentDTO> list = new ArrayList<>();
		while(rs.next()) {
			StudentDTO dto = new StudentDTO();
			dto.setId(rs.getString("id"));
			dto.setName(rs.getString("name"));
			dto.setCname(rs.getString("cname"));
			list.add(dto);
		}
		return list;
	}
	
	public List<StudentDTO> listStudent(){
		try {
			con = ds.getConnection();
			String sql = "select * from student";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			List<StudentDTO> list = makeList(rs);
			return list;
		}catch(SQLException e) {
			System.out.println("listStudent메소드 실행시 오류 발생!!");
		}finally {
			try {
				if (rs != null) rs.close();
				if (ps != null) ps.close();
				if (con != null) con.close();
			}catch(SQLException e) {}			
		}
		return null;
	}
	
	public int insertStudent(StudentDTO dto) {
		try {
			con = ds.getConnection();
			String sql = "insert into student values(?, ?, ?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getId());
			ps.setString(2, dto.getName());
			ps.setString(3, dto.getCname());
			int res = ps.executeUpdate();
			return res;
		}catch(SQLException e) {
			System.out.println("insertStudent메소드 실행시 오류 발생!!");
		}finally {
			try {
				if (ps != null) ps.close();
				if (con != null) con.close();
			}catch(SQLException e) {}			
		}
		return 0;
	}
	public int deleteStudent(String id) {
		try {
			con = ds.getConnection();
			String sql = "delete from student where id = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			int res = ps.executeUpdate();
			return res;
		}catch(SQLException e) {
			System.out.println("deleteStudent메소드 실행시 오류 발생!!");
		}finally {
			try {
				if (ps != null) ps.close();
				if (con != null) con.close();
			}catch(SQLException e) {}			
		}
		return 0;
	}
	
	public List<StudentDTO> findStudent(String name){
		try {
			con = ds.getConnection();
			String sql = "select * from student where name = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			List<StudentDTO> list = makeList(rs);
			return list;
		}catch(SQLException e) {
			System.out.println("findStudent메소드 실행시 오류 발생!!");
		}finally {
			try {
				if (rs != null) rs.close();
				if (ps != null) ps.close();
				if (con != null) con.close();
			}catch(SQLException e) {}			
		}
		return null;
	}
}











