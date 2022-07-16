package board;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	String url, user, pass;
	
	public BoardDAO(){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException e) {
			System.out.println("오라클 드라이버가 없습니다!!");
		}
		url = "jdbc:oracle:thin:@localhost:1521:xe";
		user = "spring07";
		pass = "spring07";
	}
	
	protected List<BoardDTO> makeList(ResultSet rs) 
			throws SQLException{
		List<BoardDTO> list = new ArrayList<>();
		while(rs.next()) {
			BoardDTO dto = new BoardDTO();
			dto.setNum(rs.getInt("num"));
			dto.setWriter(rs.getString("writer"));
			dto.setEmail(rs.getString("email"));
			dto.setSubject(rs.getString("subject"));
			dto.setPasswd(rs.getString("passwd"));
			dto.setReg_date(rs.getString("reg_date"));
			dto.setReadcount(rs.getInt("readcount"));
			dto.setContent(rs.getString("content"));
			dto.setIp(rs.getString("ip"));
			list.add(dto);
		}
		return list;
	}
		
	public List<BoardDTO> listBoard(){
		try {
			con = DriverManager.getConnection(url, user, pass);
			String sql = "select * from board order by num desc";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			List<BoardDTO> list = makeList(rs);
			return list;
		}catch(SQLException e) {
			System.out.println("listBoard메소드 실행시 오류 발생!!");
		}finally {
			try {
				if (rs != null) rs.close();
				if (ps != null) ps.close();
				if (con != null) con.close();
			}catch(SQLException e) {}			
		}
		return null;
	}
	
	public int insertBoard(BoardDTO dto) {
		try {
			con = DriverManager.getConnection(url, user, pass);
			String sql = "insert into board values"
					+ "(board_seq.nextval,?,?,?,?,sysdate,0,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getWriter());
			ps.setString(2, dto.getEmail());
			ps.setString(3, dto.getSubject());
			ps.setString(4, dto.getPasswd());
			ps.setString(5, dto.getContent());
			ps.setString(6, dto.getIp());
			int res = ps.executeUpdate();
			return res;
		}catch(SQLException e) {
			System.out.println("insertBoard메소드 실행시 오류 발생!!");
		}finally {
			try {
				if (ps != null) ps.close();
				if (con != null) con.close();
			}catch(SQLException e) {}			
		}
		return 0;
	}
	protected void plusReadcount(int num) throws SQLException{
		try {
			con = DriverManager.getConnection(url, user, pass);
			String sql = "update board set readcount = readcount + 1 where num = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1,  num);
			ps.executeUpdate();
		}finally {
			if (ps != null) ps.close();
			if (con != null) con.close();
		}
	}
	public BoardDTO getBoard(int num, String mode) {
		try {
			if (mode.equals("content")) {
				plusReadcount(num);
			}
			con = DriverManager.getConnection(url, user, pass);
			String sql = "select * from board where num = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, num);
			rs = ps.executeQuery();
			List<BoardDTO> list = makeList(rs);
			return list.get(0);
		}catch(SQLException e) {
			System.out.println("getBoard메소드 실행시 오류 발생!!");
		}finally {
			try {
				if (rs != null) rs.close();
				if (ps != null) ps.close();
				if (con != null) con.close();
			}catch(SQLException e) {}			
		}
		return null;
	}
	
	public int deleteBoard(int num, String passwd) {
		try {
			BoardDTO dto = getBoard(num, "password");
			if (!passwd.equals(dto.getPasswd())) {
				return -1;
			}
			con = DriverManager.getConnection(url, user, pass);
			String sql = "delete from board where num = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, num);
			int res = ps.executeUpdate();
			return res;
		}catch(SQLException e) {
			System.out.println("deleteBoard메소드 실행시 오류 발생!!");
		}finally {
			try {
				if (ps != null) ps.close();
				if (con != null) con.close();
			}catch(SQLException e) {}			
		}
		return 0;
	}
}














