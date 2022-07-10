package member;

import java.sql.*;
import java.util.*;

public class MemberDAO {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	String url, user, pass;
	
	private String search;
	private String searchString;
	public void setSearch(String search) {
		this.search = search;
	}
	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}

	public MemberDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException e) {
			System.out.println("오라클드라이버 검색 실패!!");
		}
		url = "jdbc:oracle:thin:@localhost:1521:xe";
		user = "spring07";
		pass = "spring07";
	}
	
	public boolean checkMember(String name, String ssn1, String ssn2) {
		try {
			con = DriverManager.getConnection(url, user, pass);
			String sql = "select * from member where ssn1=? and ssn2=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, ssn1);
			ps.setString(2, ssn2);
			rs = ps.executeQuery();
			if (rs.next()) {
				return true;
			}else {
				return false;
			}
		}catch(SQLException e) {
			System.out.println("checkMember()실행 중 오류 발생!!");
		}finally {
			try {
				if (rs != null) rs.close();
				if (ps != null) ps.close();
				if (con != null) con.close();
			}catch(SQLException e) {}
		}
		return false;
	}
	
	public int insertMember(MemberDTO dto) {
		try {
			con = DriverManager.getConnection(url, user, pass);
			String sql = "insert into member values"
			+ "(member_seq.nextval, ?,?,?,?,?,?,?,?,?,sysdate)";
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getName());
			ps.setString(2, dto.getId());
			ps.setString(3, dto.getPasswd());
			ps.setString(4, dto.getSsn1());
			ps.setString(5, dto.getSsn2());
			ps.setString(6, dto.getEmail());
			ps.setString(7, dto.getHp1());
			ps.setString(8, dto.getHp2());
			ps.setString(9, dto.getHp3());
			int res = ps.executeUpdate();
			return res;
		}catch(SQLException e) {
			System.out.println("insertMember()실행 중 오류 발생!!");
		}finally {
			try {
				if (ps != null) ps.close();
				if (con != null) con.close();
			}catch(SQLException e) {}
		}
		return 0;
	}

	protected List<MemberDTO> makeList(ResultSet rs) throws SQLException{
		List<MemberDTO> list = new ArrayList<>();
		while(rs.next()) {
			MemberDTO dto = new MemberDTO();
			dto.setNo(rs.getInt("no"));
			dto.setName(rs.getString("name"));
			dto.setId(rs.getString("id"));
			dto.setPasswd(rs.getString("passwd"));
			dto.setSsn1(rs.getString("ssn1"));
			dto.setSsn2(rs.getString("ssn2"));
			dto.setEmail(rs.getString("email"));
			dto.setHp1(rs.getString("Hp1"));
			dto.setHp2(rs.getString("Hp2"));
			dto.setHp3(rs.getString("Hp3"));
			dto.setJoindate(rs.getString("joindate"));
			list.add(dto);
		}
		return list;
	}
	
	public List<MemberDTO> listMember(){
		try {
			con = DriverManager.getConnection(url, user, pass);
			String sql = "select * from member";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			List<MemberDTO> list = makeList(rs);
			return list;
		}catch(SQLException e) {
			System.out.println("listMember()실행 중 오류 발생!!");
		}finally {
			try {
				if (rs != null) rs.close();
				if (ps != null) ps.close();
				if (con != null) con.close();
			}catch(SQLException e) {}
		}
		return null;
	}
	
	public int deleteMember(int no) {
		try {
			con = DriverManager.getConnection(url, user, pass);
			String sql = "delete from member where no = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, no);
			int res = ps.executeUpdate();
			return res;
		}catch(SQLException e) {
			System.out.println("deleteMember()실행 중 오류 발생!!");
		}finally {
			try {
				if (ps != null) ps.close();
				if (con != null) con.close();
			}catch(SQLException e) {}
		}
		return 0;
	}
	
	public MemberDTO getMember(int no){
		try {
			con = DriverManager.getConnection(url, user, pass);
			String sql = "select * from member where no=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, no);
			rs = ps.executeQuery();
			List<MemberDTO> list = makeList(rs);
			return list.get(0);
		}catch(SQLException e) {
			System.out.println("getMember()실행 중 오류 발생!!");
		}finally {
			try {
				if (rs != null) rs.close();
				if (ps != null) ps.close();
				if (con != null) con.close();
			}catch(SQLException e) {}
		}
		return null;
	}
	
	public int updateMember(MemberDTO dto) {
		try {
			con = DriverManager.getConnection(url, user, pass);
			String sql = "update member set passwd=?, "
				+ "email=?, hp1=?, hp2=?, hp3=? where no = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getPasswd());
			ps.setString(2, dto.getEmail());
			ps.setString(3, dto.getHp1());
			ps.setString(4, dto.getHp2());
			ps.setString(5, dto.getHp3());
			ps.setInt(6, dto.getNo());			
			int res = ps.executeUpdate();
			return res;
		}catch(SQLException e) {
			System.out.println("updateMember()실행 중 오류 발생!!");
		}finally {
			try {
				if (ps != null) ps.close();
				if (con != null) con.close();
			}catch(SQLException e) {}
		}
		return 0;
	}
	
	public List<MemberDTO> findMember(){
		try {
			con = DriverManager.getConnection(url, user, pass);
			String sql = "select * from member where "+search+" = ?";
					
			ps = con.prepareStatement(sql);
			ps.setString(1, searchString);
			rs = ps.executeQuery();
			List<MemberDTO> list = makeList(rs);
			return list;
		}catch(SQLException e) {
			System.out.println("listMember()실행 중 오류 발생!!");
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
















