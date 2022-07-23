package shop.DAO;

import shop.DTO.CategoryDTO;

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

public class CategoryDAOImpl implements CategoryDAO{

    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    static DataSource ds;

    static {
        try {
            Context init = new InitialContext();
            ds = (DataSource)init.lookup("java:comp/env/jdbc/oracle");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int categoryInsert(CategoryDTO dto) {
        try {
            String sql = "INSERT INTO CATEGORY VALUES(cate_seq.nextval, ?, ?)";
            conn = ds.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, dto.getCode());
            pstmt.setString(2, dto.getCname());

            int res = pstmt.executeUpdate();
            return res;
        } catch (SQLException e) {
            System.out.println("categoryInsert() 메소드에서 오류가 발생했습니다." + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
            }
        }
        return 0;
    }

    protected List<CategoryDTO> makeList(ResultSet rs) throws SQLException{
        List<CategoryDTO> list = new ArrayList<>();
        while(rs.next()){
            CategoryDTO dto = new CategoryDTO();
            dto.setCname(rs.getString("cname"));
            dto.setCnum(rs.getInt("cnum"));
            dto.setCode(rs.getString("code"));
            list.add(dto);
        }
        return list;
    }

    @Override
    public List<CategoryDTO> categoryList() {
        try {
            String sql = "SELECT * FROM CATEGORY ORDER BY cnum DESC";
            conn = ds.getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            List<CategoryDTO> list = makeList(rs);
            return list;
        } catch (SQLException e) {
            System.out.println("categoryList() 메소드에서 오류가 발생했습니다.");
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch(SQLException e) {}
        }
        return null;
    }

    @Override
    public int categoryDelete(int num) {
        try {
            String sql = "Delete from category where cnum = ?";
            conn = ds.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, num);
            int res = pstmt.executeUpdate();
            return res;
        } catch (SQLException e) {
            System.out.println("categoryDelete() 메소드에서 오류가 발생했습니다." + e.getMessage());
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch(SQLException e) {}
        }
        return 0;
    }
}
