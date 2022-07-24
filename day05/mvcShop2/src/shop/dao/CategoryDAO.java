package shop.dao;

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

import shop.dto.CategoryDTO;

public class CategoryDAO {
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
	
	public int insertCate(CategoryDTO dto) {
		try {
			con = ds.getConnection();
			String sql = "insert into category values(cate_seq.nextval, ?, ?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getCode());
			ps.setString(2, dto.getCname());
			int res = ps.executeUpdate();
			return res;
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("insertCate메소드 실행 중 오류 발생!!");
		}finally {
			try {
				if (ps != null) ps.close();
				if (con != null) con.close();
			}catch(SQLException e) {}
		}
		return 0;
	}
	
	public List<CategoryDTO> listCate(){
		try {
			con = ds.getConnection();
			String sql = "select * from category";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			List<CategoryDTO> list = new ArrayList<>();
			while(rs.next()) {
				CategoryDTO dto = new CategoryDTO();
				dto.setCnum(rs.getInt("cnum"));
				dto.setCode(rs.getString("code"));
				dto.setCname(rs.getString("cname"));
				list.add(dto);
			}
			return list;
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("listCate메소드 실행 중 오류 발생!!");
		}finally {
			try {
				if (rs != null) rs.close();
				if (ps != null) ps.close();
				if (con != null) con.close();
			}catch(SQLException e) {}
		}
		return null;
	}
	
	public int deleteCate(int cnum) {
		try {
			con = ds.getConnection();
			String sql = "delete from category where cnum = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, cnum);
			int res = ps.executeUpdate();
			return res;
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("deleteCate메소드 실행 중 오류 발생!!");
		}finally {
			try {
				if (ps != null) ps.close();
				if (con != null) con.close();
			}catch(SQLException e) {}
		}
		return 0;
	}
}












