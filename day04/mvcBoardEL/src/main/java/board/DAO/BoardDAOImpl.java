package board.DAO;

import board.DTO.BoardDTO;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BoardDAOImpl implements BoardDAO {

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

    protected List<BoardDTO> makeList(ResultSet rs)
            throws SQLException {
        List<BoardDTO> list = new ArrayList<>();
        while (rs.next()) {
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
            conn = ds.getConnection();
            String sql = "select * from board order by num desc";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            List<BoardDTO> list = makeList(rs);
            return list;
        } catch (SQLException e) {
            System.out.println("listBoard�޼ҵ� ����� ���� �߻�!!");
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
            }
        }
        return null;
    }

    @Override
    public BoardDTO getBoard(int num, String mode) {
        try {
            if (mode.equals("content")) {
                plusReadcount(num);
            }
            conn = ds.getConnection();
            String sql = "select * from board where num = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, num);
            rs = pstmt.executeQuery();
            List<BoardDTO> list = makeList(rs);
            return list.get(0);
        } catch (SQLException e) {
            System.out.println("getBoard 메소드에서 오류가 발생했습니다.!!");
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
            }
        }
        return null;
    }

    protected void plusReadcount(int num) throws SQLException{
        try {
            conn = ds.getConnection();
            String sql = "update board set readcount = readcount + 1 where num = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,  num);
            pstmt.executeUpdate();
        }finally {
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        }
    }

    @Override
    public int insertBoard(BoardDTO dto) {
        try {
            conn = ds.getConnection();
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
        } catch (SQLException e) {
            System.out.println("insertBoard메소드에서 에러가 발생했습니다.!!" + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
            }
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
            conn = ds.getConnection();
            String sql = "update board set email=?, subject=?, content=? where num=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, dto.getEmail());
            pstmt.setString(2, dto.getSubject());
            pstmt.setString(3, dto.getContent());
            pstmt.setInt(4, dto.getNum());
            int res = pstmt.executeUpdate();
            return res;
        } catch (SQLException e) {
            System.out.println("updateBoard메소드에서 오류가 발생했습니다.!!" +e.getMessage());
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
            }
        }
        return 0;
    }

    @Override
    public int deleteBoard(int num, String passwd) {
        return 0;
    }
}
