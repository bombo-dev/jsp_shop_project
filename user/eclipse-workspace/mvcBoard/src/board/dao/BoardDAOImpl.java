package board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import board.dto.BoardDTO;

public class BoardDAOImpl implements BoardDAO {

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
	
	protected List<BoardDTO> makeList(ResultSet rs) throws SQLException{
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
	
	@Override
	public List<BoardDTO> listBoard() {
		try {
			con = ds.getConnection();
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

	protected void plusReadcount(int num) throws SQLException{
		try {
			con = ds.getConnection();
			String sql = "update board set readcount = readcount + 1 where num = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1,  num);
			ps.executeUpdate();
		}finally {
			if (ps != null) ps.close();
			if (con != null) con.close();
		}
	}
	
	@Override
	public BoardDTO getBoard(int num, String mode) {
		try {
			if (mode.equals("content")) {
				plusReadcount(num);
			}
			con = ds.getConnection();
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

	@Override
	public int insertBoard(BoardDTO dto) {
		try {
			con = ds.getConnection();
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

	@Override
	public int updateBoard(BoardDTO dto) {
		try {
			BoardDTO dto2 = getBoard(dto.getNum(), "password");
			if (!dto.getPasswd().equals(dto2.getPasswd())) {
				return -1;
			}
			con =ds.getConnection();
			String sql = "update board set email=?, subject=?, content=? where num=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getEmail());
			ps.setString(2, dto.getSubject());
			ps.setString(3, dto.getContent());
			ps.setInt(4, dto.getNum());
			int res = ps.executeUpdate();
			return res;
		}catch(SQLException e) {
			System.out.println("updateBoard메소드 실행시 오류 발생!!");
		}finally {
			try {
				if (ps != null) ps.close();
				if (con != null) con.close();
			}catch(SQLException e) {}			
		}
		return 0;
	}

	@Override
	public int deleteBoard(int num, String passwd) {
		try {
			BoardDTO dto = getBoard(num, "password");
			if (!passwd.equals(dto.getPasswd())) {
				return -1;
			}
			con = ds.getConnection();
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
