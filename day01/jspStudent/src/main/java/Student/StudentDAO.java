package Student;
import java.sql.*;
import java.util.*;

public class StudentDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	String url, user, password;
	
	public StudentDAO(){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException e) {
			System.out.println("oracle 드라이버를 찾지 못하였습니다.");
		}
		url = "jdbc:oracle:thin:@localhost:1521:xe";
		user = "spring07";
		password = "spring07";
	}

	protected List<StudentDTO> makeList(ResultSet rs) throws SQLException {
		List<StudentDTO> list = new ArrayList<StudentDTO>();
		while(rs.next()){
			StudentDTO dto = new StudentDTO();
			dto.setId(rs.getString("id"));
			dto.setCname(rs.getString("cname"));
			dto.setName(rs.getString("name"));
			list.add(dto);
		}
		return list;
	}

	public List<StudentDTO> listStudent() {
		try {
			conn = DriverManager.getConnection(url, user, password);
			String sql = "select * from student";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			List<StudentDTO> list = makeList(rs);
			return list;
		} catch (SQLException e) {
			System.out.println("listStudent 메소드에서 에러가 발생했습니다.");
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) pstmt.close();
			} catch(SQLException e){ }
		}
		return null;
	}

	public int insertStudent(StudentDTO dto) {
		try {
			conn = DriverManager.getConnection(url, user, password);
			String sql = "INSERT INTO STUDENT VALUES(?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getCname());
			int res = pstmt.executeUpdate();
			return res;
		} catch (SQLException e) {
			System.out.println("insertStudent 메소드에서 오류가 발생했습니다.");
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) pstmt.close();
			} catch(SQLException e){}
		}
		return 0;
	}

	public StudentDTO selectOne(StudentDTO dto){
		try {
			conn = DriverManager.getConnection(url, user, password);
			String sql = "select * from Student where name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());

			rs = pstmt.executeQuery();
			rs.next();

			StudentDTO row = new StudentDTO();
			row.setName(rs.getString("name"));
			row.setCname(rs.getString("cname"));
			row.setId(rs.getString("id"));

			return row;

		} catch (SQLException e) {
			System.out.println("selectOne 메소드에서 오류가 발생했습니다.");
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch(SQLException e){}
		}
		return null;
	}

	public int delete(StudentDTO dto) {
		try {
			conn = DriverManager.getConnection(url, user, password);
			String sql = "DELETE FROM STUDENT WHERE ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			int res = pstmt.executeUpdate();
			return res;
		} catch (SQLException e) {
			System.out.println("delete 메소드를 실행하였습니다.");
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch(SQLException e){}
		}
		return 0;
	}
}











