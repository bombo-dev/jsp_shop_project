package DAO;

import DTO.ProductDTO;
import com.oreilly.servlet.MultipartRequest;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {
    private Connection conn;
    private PreparedStatement pstmt;
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
            conn = ds.getConnection();
            String sql = "insert into product values(prod_seq.nextval, ?,?,?,?,?,?,?,?,?,sysdate)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, mr.getParameter("pname"));
            String pcategory_fk = mr.getParameter("pcategory_fk");
            pcategory_fk += mr.getParameter("pcode");
            pstmt.setString(2, pcategory_fk);
            pstmt.setString(3, mr.getParameter("pcompany"));
            pstmt.setString(4, mr.getFilesystemName("pimage"));
            pstmt.setInt(5, Integer.parseInt(mr.getParameter("pqty")));
            pstmt.setInt(6, Integer.parseInt(mr.getParameter("price")));
            pstmt.setString(7, mr.getParameter("pspec"));
            pstmt.setString(8, mr.getParameter("pcontents"));
            pstmt.setInt(9, Integer.parseInt(mr.getParameter("point")));
            int res = pstmt.executeUpdate();
            return res;
        }catch(SQLException e) {
            System.out.println("insertProd 메소드에서 오류가 발생했습니다.!!");
            e.printStackTrace();
        }finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
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
            conn = ds.getConnection();
            String sql = "select * from product";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            List<ProductDTO> list = makeList(rs);
            return list;
        }catch(SQLException e) {
            System.out.println("listProd �޼ҵ� ���� �� ���� �߻�!!");
            e.printStackTrace();
        }finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            }catch(SQLException e) {}
        }
        return null;
    }

    @Override
    public ProductDTO viewProd(int pnum) {
        try {
            conn = ds.getConnection();
            String sql = "select * from PRODUCT WHERE PNUM = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, pnum);
            rs = pstmt.executeQuery();

            rs.next();

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

            return dto;
        } catch (SQLException e) {
            System.out.println("viewProd() 메소드에서 오류가 발생했습니다." + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            }catch(SQLException e) {}
        }
        return null;
    }

    public int deleteProd(int pnum) {
        try {
            conn = ds.getConnection();
            String sql = "delete from product where pnum = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, pnum);
            int res = pstmt.executeUpdate();
            return res;
        }catch(SQLException e) {
            System.out.println("deleteProduct 메소드에서 오류가 발생했습니다.!!");
            e.printStackTrace();
        }finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            }catch(SQLException e) {}
        }
        return 0;
    }

    @Override
    public int updateProd(MultipartRequest mr) {
        try {
            conn = ds.getConnection();
            String sql = "update product set pname=?, pcompany=?, pimage=?, "
                    + "pqty=?, price=?, pspec=?, pcontents=?, point=? where pnum=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, mr.getParameter("pname"));
            pstmt.setString(2, mr.getParameter("pcompany"));
            String pimage = mr.getFilesystemName("pimage");
            if (pimage == null) {
                pimage = mr.getParameter("pimage2");
            }
            pstmt.setString(3, pimage);
            pstmt.setInt(4, Integer.parseInt(mr.getParameter("pqty")));
            pstmt.setInt(5, Integer.parseInt(mr.getParameter("price")));
            pstmt.setString(6, mr.getParameter("pspec"));
            pstmt.setString(7, mr.getParameter("pcontents"));
            pstmt.setInt(8, Integer.parseInt(mr.getParameter("point")));
            pstmt.setInt(9, Integer.parseInt(mr.getParameter("pnum")));
            int res = pstmt.executeUpdate();
            return res;
        }catch(SQLException e) {
            System.out.println("updateProd 메소드 실행 중 오류 발생!!");
            e.printStackTrace();
        }finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            }catch(SQLException e) {}
        }
        return 0;
    }
}
