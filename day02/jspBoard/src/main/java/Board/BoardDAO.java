package Board;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO {
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    String url, user, password;

    public BoardDAO(){
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        }catch(ClassNotFoundException e) {
            System.out.println("오라클 드라이버가 없습니다!!");
        }
        url = "jdbc:oracle:thin:@localhost:1521:xe";
        user = "spring07";
        password = "spring07";
    }

    public List<BoardDTO> listBoard(BoardDTO dto) {
        try {
            List<BoardDTO> list = new ArrayList<>();
            String sql = "select * from board order by num desc";
            conn = DriverManager.getConnection(url, user, password);
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while(rs.next()){
                BoardDTO board = new BoardDTO();
                board.setWriter(rs.getString("writer"));
                board.setContent(rs.getString("content"));
                board.setEmail(rs.getString("email"));
                board.setNum(rs.getInt("num"));
                board.setIp(rs.getString("ip"));
                board.setReadcount(rs.getInt("readcount"));
                board.setSubject(rs.getString("subject"));
                board.setWriter(rs.getString("writer"));
                board.setReg_date(rs.getString("reg_date"));
                list.add(board);
            }
            return list;
        } catch (SQLException e) {
            System.out.println("listBoard 메소드에서 오류가 발생했습니다." +e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch(SQLException e) {}
        }
        return null;
    }

    public int insertBoard(BoardDTO dto) {
        try {
            conn = DriverManager.getConnection(url, user, password);
            String sql = "insert into board values"
                    + "(board_seq.nextval,?,?,?,?,sysdate,0,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, dto.getWriter());
            pstmt.setString(2, dto.getEmail());
            pstmt.setString(3, dto.getSubject());
            pstmt.setString(4, dto.getPasswd());
            pstmt.setString(5, dto.getContent());
            pstmt.setString(6, dto.getIp());
            int res = pstmt.executeUpdate();
            return res;
        }catch(SQLException e) {
            System.out.println("insertBoard메소드 실행시 오류 발생!!");
        }finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            }catch(SQLException e) {}
        }
        return 0;
    }


}
