package board;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO {

    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    String url, user, password;

    public BoardDAO() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch(ClassNotFoundException e){
            System.out.println("드라이버를 불러오는데 실패했습니다.");
        }

        url = "jdbc:oracle:thin:@DB20220615173113_high?TNS_ADMIN=/Users/munjong-un/wallet/cloudwallet/Wallet_DB20220615173113";
        user = "Springuser";
        password = "Spring12345678";
    }

    protected List<BoardDTO> makeList(ResultSet rs) throws SQLException {
        List<BoardDTO> list = new ArrayList<>();

        while(rs.next()){
            BoardDTO board = new BoardDTO();
            board.setNum(rs.getInt("num"));
            board.setWriter(rs.getString("writer"));
            board.setEmail(rs.getString("email"));
            board.setSubject(rs.getString("subject"));
            board.setPasswd(rs.getString("passwd"));
            board.setReg_date(rs.getString("reg_date"));
            board.setReadcount(rs.getInt("readcount"));
            board.setContent(rs.getString("content"));
            board.setIp(rs.getString("ip"));

            list.add(board);
        }
        return list;
    }

    public List<BoardDTO> listBoard() {
        try {
            String sql = "select * from board order by num desc";
            conn = DriverManager.getConnection(url, user, password);
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            List<BoardDTO> list = makeList(rs);
            return list;

        } catch (SQLException e) {
            System.out.println("listBoard() 를 불러오는 도중에 오류가 발생했습니다." + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e){}
        }
        return null;
    }

    public int insertBoard(BoardDTO dto){
        try {
            String sql = "INSERT INTO BOARD VALUES (board_seq.nextval, ?, ?, ?, ?, sysdate, 0, ?, ?)";
            conn = DriverManager.getConnection(url, user, password);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, dto.getWriter());
            pstmt.setString(2, dto.getEmail());
            pstmt.setString(3, dto.getSubject());
            pstmt.setString(4, dto.getPasswd());
            pstmt.setString(5, dto.getContent());
            pstmt.setString(6, dto.getIp());

            int res = pstmt.executeUpdate();
            return res;
        } catch (SQLException e) {
            System.out.println("insertBoard() 메소드에서 오류가 발생했습니다.");
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e){

            }
        }
        return 0;
    }
    protected void plusReadcount(int num) throws SQLException{
        try {
            String sql = "UPDATE BOARD SET READCOUNT = READCOUNT + 1 WHERE NUM = ?";
            conn = DriverManager.getConnection(url, user, password);
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, num);

            pstmt.executeUpdate();
        } finally {
            if(pstmt != null) pstmt.close();
            if(conn != null) conn.close();
        }
    }

    public BoardDTO getBoard(int num, String mode){
        try {
            if(mode.equals("content")) {
                plusReadcount(num);
            }
            String sql = "select * from board where num = ?";
            conn = DriverManager.getConnection(url, user, password);
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, num);
            rs = pstmt.executeQuery();

            List<BoardDTO> list = makeList(rs);
            return list.get(0);
        } catch (SQLException e) {
            System.out.println("getMember() 메소드에서 오류가 발생했습니다!");
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch(SQLException e){}
        }
        return null;
    }

    public int deleteBoard(int num, String passwd){
        try {
            BoardDTO dto = getBoard(num, "password");
            if (!passwd.equals(dto.getPasswd())) {
                return -1;
            }
            String sql = "delete from board where num = ?";
            conn = DriverManager.getConnection(url, user, password);
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, num);
            int res = pstmt.executeUpdate();
            return res;
        } catch (SQLException e) {
            System.out.println("deleteBoard() 메소드에서 오류가 발생했습니다.");
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch(SQLException e){}
        }
        return 0;
    }

    public int updateBoard(int num, BoardDTO dto) {
        try {
            String sql = "UPDATE BOARD SET writer = ?, email = ?, content = ? WHERE num = ?";
            conn = DriverManager.getConnection(url, user, password);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, dto.getWriter());
            pstmt.setString(2, dto.getEmail());
            pstmt.setString(3, dto.getContent());
            pstmt.setInt(4, num);
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("updateBoard() 메소드에서 오류가 발생했습니다.");
        } finally {
            try {
                if(pstmt != null) pstmt.close();
                if(conn != null) conn.close();
            } catch(SQLException e) {}
        }
        return 0;
    }

    public int passwdCheck(int num, String passwd){
        try {
            BoardDTO dto = getBoard(num, "password");
            if (!passwd.equals(dto.getPasswd())) {
                return -1;
            } else {
                return 1;
            }
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch(SQLException e){}
        }
    }

}
