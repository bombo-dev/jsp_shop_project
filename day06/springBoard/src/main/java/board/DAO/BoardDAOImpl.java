package board.DAO;

import board.DTO.BoardDTO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class BoardDAOImpl implements BoardDAO {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    class MyRowMapper implements RowMapper<BoardDTO> {

        @Override
        public BoardDTO mapRow(ResultSet rs, int i) throws SQLException {
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
            return dto;
        }
    }

    @Override
    public List<BoardDTO> listBoard() {
        String sql = "SELECT * FROM BOARD";
        MyRowMapper mapper = new MyRowMapper();

        List<BoardDTO> list = jdbcTemplate.query(sql, mapper);
        return list;
    }

    @Override
    public BoardDTO getBoard(int num, String mode) {
        if (mode.equals("content")) {
            plusReadcount(num);
        }
        String sql = "select * from board where num = ?";
        List<BoardDTO> list = jdbcTemplate.query(sql, new MyRowMapper(), num);

        return list.get(0);
    }

    protected void plusReadcount(int num) {
        String sql = "update board set readcount = readcount + 1 where num = ?";
        jdbcTemplate.update(sql, num);
    }

    @Override
    public int insertBoard(BoardDTO dto) {
        String sql = "INSERT INTO BOARD VALUES (board_seq.nextval,?,?,?,?,sysdate,0,?,?)";
        Object[] values = new Object[]{dto.getWriter(), dto.getEmail(), dto.getSubject(), dto.getPasswd(), dto.getContent(), dto.getIp()};
        int res = jdbcTemplate.update(sql, values);

        return res;
    }

    @Override
    public int updateBoard(BoardDTO dto) {
        BoardDTO dto2 = getBoard(dto.getNum(), "password");
        if (!dto.getPasswd().equals(dto2.getPasswd())) {
            return -1;
        }
        String sql = "update board set email=?, subject=?, content=? where num=?";
        Object[] values = new Object[]{dto.getEmail(), dto.getSubject(), dto.getContent(), dto.getNum()};
        int res = jdbcTemplate.update(sql, values);
        return res;
    }

    @Override
    public int deleteBoard(int num, String passwd) {
        BoardDTO dto = getBoard(num, "password");
        if (!passwd.equals(dto.getPasswd())) {
            return -1;
        }

        String sql = "delete from board where num = ?";
        int res = jdbcTemplate.update(sql, num);
        return res;
    }
}
