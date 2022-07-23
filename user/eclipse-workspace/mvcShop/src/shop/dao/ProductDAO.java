package shop.dao;

import java.sql.*;
import java.util.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.oreilly.servlet.MultipartRequest;

import shop.dto.ProductDTO;

public class ProductDAO {
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
	
	public int insertProd(MultipartRequest mr) {
		try {
			con = ds.getConnection();
			String sql = "insert into product values(prod_seq.nextval, ?,?,?,?,?,?,?,?,?,sysdate)";
			ps = con.prepareStatement(sql);
			ps.setString(1, mr.getParameter("pname"));
			String pcategory_fk = mr.getParameter("pcategory_fk");
			pcategory_fk += mr.getParameter("pcode");
			ps.setString(2, pcategory_fk);
			ps.setString(3, mr.getParameter("pcompany"));
			ps.setString(4, mr.getFilesystemName("pimage"));
			ps.setInt(5, Integer.parseInt(mr.getParameter("pqty")));
			ps.setInt(6, Integer.parseInt(mr.getParameter("price")));
			ps.setString(7, mr.getParameter("pspec"));
			ps.setString(8, mr.getParameter("pcontents"));
			ps.setInt(9, Integer.parseInt(mr.getParameter("point")));
			int res = ps.executeUpdate();
			return res;
		}catch(SQLException e) {
			System.out.println("insertProd 메소드 실행 중 오류 발생!!");
			e.printStackTrace();
		}finally {
			try {
				if (ps != null) ps.close();
				if (con != null) con.close();
			}catch(SQLException e) {}
		}
		return 0;
	}
	
	protected List<ProductDTO> makeList(ResultSet rs) throws SQLException {
		List<ProductDTO> list = new ArrayList<>();
		while(rs.next()) {
			ProductDTO dto = new ProductDTO();
			dto.setPnum(rs.getInt("pnum"));
			dto.setPname(rs.getString("pname"));
			dto.setPcategory_fk(rs.getString("pcategory_fk"));
			dto.setPcompany(rs.getString("pcompany"));
			dto.setPimage(rs.getString("pimage"));
			dto.setPqty(rs.getInt("pqty"));
			dto.setPrice(rs.getInt("price"));
			dto.setPspec(rs.getString("pspec"));
			dto.setPcontents(rs.getString("pcontents"));
			dto.setPoint(rs.getInt("point"));
			dto.setPinputdate(rs.getString("pinputdate"));
			list.add(dto);
		}
		return list;
	}
	
	public List<ProductDTO> listProd() {
		try {
			con = ds.getConnection();
			String sql = "select * from product";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			List<ProductDTO> list = makeList(rs);
			return list;
		}catch(SQLException e) {
			System.out.println("listProd 메소드 실행 중 오류 발생!!");
			e.printStackTrace();
		}finally {
			try {
				if (rs != null) rs.close();
				if (ps != null) ps.close();
				if (con != null) con.close();
			}catch(SQLException e) {}
		}
		return null;
	}
	
	public ProductDTO getProduct(int pnum) {
		try {
			con = ds.getConnection();
			String sql = "select * from product where pnum = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, pnum);
			rs = ps.executeQuery();
			List<ProductDTO> list = makeList(rs);
			return list.get(0);
		}catch(SQLException e) {
			System.out.println("getProduct 메소드 실행 중 오류 발생!!");
			e.printStackTrace();
		}finally {
			try {
				if (rs != null) rs.close();
				if (ps != null) ps.close();
				if (con != null) con.close();
			}catch(SQLException e) {}
		}
		return null;
	}
	
	public int deleteProd(int pnum) {
		try {
			con = ds.getConnection();
			String sql = "delete from product where pnum = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, pnum);
			int res = ps.executeUpdate();
			return res;
		}catch(SQLException e) {
			System.out.println("deleteProduct 메소드 실행 중 오류 발생!!");
			e.printStackTrace();
		}finally {
			try {
				if (ps != null) ps.close();
				if (con != null) con.close();
			}catch(SQLException e) {}
		}
		return 0;
	}
	
	public int updateProd(MultipartRequest mr) {
		try {
			con = ds.getConnection();
			String sql = "update product set pname=?, pcompany=?, pimage=?, "
					+ "pqty=?, price=?, psep=?, pcontents=?, point=? where pnum=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, mr.getParameter("pname"));
			ps.setString(2, mr.getParameter("pcompany"));
			String pimage = mr.getFilesystemName("pimage");
			if (pimage == null) {
				pimage = mr.getParameter("pimage2");
			}
			ps.setString(3, pimage);
			ps.setInt(4, Integer.parseInt(mr.getParameter("pqty")));
			ps.setInt(5, Integer.parseInt(mr.getParameter("price")));
			ps.setString(6, mr.getParameter("pspec"));
			ps.setString(7, mr.getParameter("pcontents"));
			ps.setInt(8, Integer.parseInt(mr.getParameter("point")));
			ps.setInt(9, Integer.parseInt(mr.getParameter("pnum")));
			int res = ps.executeUpdate();
			return res;
		}catch(SQLException e) {
			System.out.println("updateProd 메소드 실행 중 오류 발생!!");
			e.printStackTrace();
		}finally {
			try {
				if (ps != null) ps.close();
				if (con != null) con.close();
			}catch(SQLException e) {}
		}
		return 0;
	}
	
	public List<ProductDTO> selectBySpec(String spec) {
		try {
			con = ds.getConnection();
			String sql = "select * from product where pspec = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, spec);
			rs = ps.executeQuery();
			List<ProductDTO> list = makeList(rs);
			return list;
		}catch(SQLException e) {
			System.out.println("selectBySpec 메소드 실행 중 오류 발생!!");
			e.printStackTrace();
		}finally {
			try {
				if (rs != null) rs.close();
				if (ps != null) ps.close();
				if (con != null) con.close();
			}catch(SQLException e) {}
		}
		return null;
	}
	
	public List<ProductDTO> selectByCode(String code) {
		try {
			con = ds.getConnection();
			String sql = "select * from product where pcategory_fk like ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, code+"%");
			rs = ps.executeQuery();
			List<ProductDTO> list = makeList(rs);
			return list;
		}catch(SQLException e) {
			System.out.println("selectByCode 메소드 실행 중 오류 발생!!");
			e.printStackTrace();
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














