package DAO;

import DTO.ProductDTO;

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

public class MallDAOImpl implements MallDAO{

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

    @Override
    public List<ProductDTO> hitProductView() {
        try {
            String sql = "SELECT * from PRODUCT WHERE pspec = 'HIT'";
            conn = ds.getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            List<ProductDTO> list = new ArrayList<>();
            while(rs.next()){
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
        } catch (SQLException e) {
            System.out.println("hitProductView() 메소드에서 오류가 발생했습니다." + e.getMessage());
            e.printStackTrace();
        } finally{
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch(SQLException e){}
        }
        return null;
    }

    @Override
    public List<ProductDTO> newProductView() {
        try {
            String sql = "SELECT * from PRODUCT WHERE pspec = 'NEW'";
            conn = ds.getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            List<ProductDTO> list = new ArrayList<>();
            while(rs.next()){
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
        } catch (SQLException e) {
            System.out.println("NEWProductView() 메소드에서 오류가 발생했습니다." + e.getMessage());
            e.printStackTrace();
        } finally{
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch(SQLException e){}
        }
        return null;
    }

    @Override
    public List<ProductDTO> bestProductView() {
        try {
            String sql = "SELECT * from PRODUCT WHERE pspec = 'BEST'";
            conn = ds.getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            List<ProductDTO> list = new ArrayList<>();
            while(rs.next()){
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
        } catch (SQLException e) {
            System.out.println("bestProductView() 메소드에서 오류가 발생했습니다." + e.getMessage());
            e.printStackTrace();
        } finally{
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch(SQLException e){}
        }
        return null;
    }

    @Override
    public List<ProductDTO> pspecProductView(String pspec) {
        try {
            String sql = "SELECT * from PRODUCT WHERE pspec = ?";
            conn = ds.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, pspec);
            rs = pstmt.executeQuery();
            List<ProductDTO> list = new ArrayList<>();
            while(rs.next()){
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
        } catch (SQLException e) {
            System.out.println("NEWProductView() 메소드에서 오류가 발생했습니다." + e.getMessage());
            e.printStackTrace();
        } finally{
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch(SQLException e){}
        }
        return null;
    }

    @Override
    public List<ProductDTO> categoryProductView(String category) {
        try {
            String sql = "select * from product where pnum IN (SELECT PNUM FROM PRODUCT WHERE SUBSTR(PCATEGORY_FK, 1, 4) = ?)";
            conn = ds.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, category);
            rs = pstmt.executeQuery();

            List<ProductDTO> list = new ArrayList<>();
            while(rs.next()){
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
        } catch (SQLException e) {
            System.out.println("categoryProductView() 메소드에서 오류가 발생하였습니다." +e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            }catch(SQLException e){}
        }

        return null;
    }
}
