package student.DAO;

import student.DTO.StudentDTO;

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

public class StudentDAOImpl implements StudentDAO {

    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;
    static DataSource ds;

    static {
        try{
            Context init = new InitialContext();
            ds = (DataSource)init.lookup("java:comp/env/jdbc/oracle");
        }catch (NamingException e){
            e.printStackTrace();
        }
    }

    protected List<StudentDTO> makeList(ResultSet rs) throws SQLException {

        List<StudentDTO> list = new ArrayList<>();

        while(rs.next()){
            StudentDTO dto = new StudentDTO();
            dto.setId(rs.getString("id"));
            dto.setName(rs.getString("name"));
            dto.setCname(rs.getString("cname"));
            list.add(dto);
        }

        return list;
    }

    @Override
    public List<StudentDTO> listStudent() {
        try {
            String sql = "select * from student";
            conn = ds.getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            List<StudentDTO> list = makeList(rs);
            return list;
        } catch (SQLException e) {
            System.out.println("listStudent() 메소드에서 에러가 발생했습니다.");
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch(SQLException e){}
        }
        return null;
    }

    @Override
    public int insertStudent(StudentDTO dto) {
        try {
            String sql = "INSERT INTO STUDENT VALUES (?, ?, ?)";
            conn = ds.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, dto.getId());
            pstmt.setString(2, dto.getName());
            pstmt.setString(3, dto.getCname());
            int res = pstmt.executeUpdate();
            return res;
        } catch (SQLException e) {
            System.out.println("insertStudent() 메소드에서 오류가 발생했습니다.");
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch(SQLException e) {}
        }
        return 0;
    }

    @Override
    public StudentDTO getStudent(String name) {
        try {
            String sql = "SELECT * FROM STUDENT WHERE name = ?";
            conn = ds.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            rs = pstmt.executeQuery();

            rs.next();

            StudentDTO dto = new StudentDTO();
            dto.setId(rs.getString("id"));
            dto.setName(rs.getString("name"));
            dto.setCname(rs.getString("cname"));

            return dto;
        } catch (SQLException e) {
            System.out.println("getStudent 메소드에서 오류가 발생했습니다.");
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch(SQLException e){}
        }
        return null;
    }

    @Override
    public int delete(String id) {
        try {
            String sql = "DELETE FROM STUDENT WHERE ID = ?";
            conn = ds.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            int res = pstmt.executeUpdate();
            return res;
        } catch (SQLException e) {
            System.out.println("delete() 메소드에서 오류가 발생했습니다.");
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch(SQLException e){}
        }
        return 0;
    }
}
