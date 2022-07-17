package DAO;

import DTO.CategoryDTO;

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

public class CategoryDAOImpl implements CategoryDAO {

    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    static DataSource ds;

    static {
        try {
            Context init = new InitialContext();
            ds = (DataSource) init.lookup("java:/comp/env/jdbc/oracleXE");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    protected List<CategoryDTO> makeList(ResultSet rs)
            throws SQLException {
        List<CategoryDTO> list = new ArrayList<>();
        while (rs.next()) {
            CategoryDTO dto = new CategoryDTO();
            dto.setCname(rs.getString("cname"));
            dto.setCnum(rs.getInt("cnum"));
            dto.setCode(rs.getString("code"));
            list.add(dto);
        }
        return list;
    }

    @Override
    public List<CategoryDTO> listCategory() {
        try {
            String sql = "select * from category order by cnum desc";
            conn = ds.getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            List<CategoryDTO> list = makeList(rs);

            return list;
        } catch (SQLException e) {
            System.out.println("listCategory() 메소드에서 오류가 발생했습니다." + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
            } catch(SQLException e) {}
        }
        return null;
    }

    @Override
    public int insertCategory(CategoryDTO dto) {
        try {
            String sql = "Insert into category Values(cate_seq.nextval,?, ?)";
            conn = ds.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, dto.getCode());
            pstmt.setString(2, dto.getCname());

            int res = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("insertCategory() 메소드에서 오류가 발생했습니다." + e.getMessage());
        }
        return 0;
    }
}
