package Student;
import java.sql.*;
import java.util.*;

public class StudentDAO {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	String url, user, pass;
	
	public StudentDAO(){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException e) {
			System.out.println("����Ŭ ����̹��� �����ϴ�!!");
		}
		url = "jdbc:oracle:thin:@localhost:1521:xe";
		user = "spring07";
		pass = "spring07";
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
			con = DriverManager.getConnection(url, user, pass);
			String sql = "select * from student";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			List<StudentDTO> list = makeList(rs);
			return list;
		}catch(SQLException e) {
			System.out.println("listStudent�޼ҵ� ����� ���� �߻�!!");
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
			con = DriverManager.getConnection(url, user, pass);
			String sql = "insert into student values(?, ?, ?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getId());
			ps.setString(2, dto.getName());
			ps.setString(3, dto.getCname());
			int res = ps.executeUpdate();
			return res;
		}catch(SQLException e) {
			System.out.println("insertStudent�޼ҵ� ����� ���� �߻�!!");
		}finally {
			try {
				if (ps != null) ps.close();
				if (con != null) con.close();
			}catch(SQLException e) {}			
		}
		return 0;
	}
}











