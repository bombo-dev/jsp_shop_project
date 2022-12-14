package dao;

import dto.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MemberDAOImpl implements MemberDAO {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    class MyRowMapper implements RowMapper<MemberDTO> {

        @Override
        public MemberDTO mapRow(ResultSet rs, int i) throws SQLException {
            MemberDTO dto = new MemberDTO();
            dto.setNo(rs.getInt("no"));
            dto.setName(rs.getString("name"));
            dto.setId(rs.getString("id"));
            dto.setPasswd(rs.getString("passwd"));
            dto.setSsn1(rs.getString("ssn1"));
            dto.setSsn2(rs.getString("ssn2"));
            dto.setEmail(rs.getString("email"));
            dto.setHp1(rs.getString("Hp1"));
            dto.setHp2(rs.getString("Hp2"));
            dto.setHp3(rs.getString("Hp3"));
            dto.setJoindate(rs.getString("joindate"));
            return dto;
        }
    }

    public boolean checkMember(String name, String ssn1, String ssn2) {
        String sql = "select * from member where ssn1=? and ssn2=?";
        Object[] values = new Object[]{ssn1, ssn2};
        List<MemberDTO> list = jdbcTemplate.query(sql, new MyRowMapper(), values);
        if (list.size() != 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<MemberDTO> findMember(String search, String searchString) {
        String sql = "select * from member where " + search + " = ?";

        List<MemberDTO> list = jdbcTemplate.query(sql, new MyRowMapper(), searchString);
        if (list.size() == 0) {
            return null;
        } else {
            return list;
        }
    }

    @Override
    public int insertMember(MemberDTO dto) {
        String sql = "insert into member values "
                + "(member_seq.nextval, ?,?,?,?,?,?,?,?,?,sysdate)";

        Object[] values = new Object[]{dto.getName(), dto.getId(), dto.getPasswd(),
                dto.getSsn1(), dto.getSsn2(), dto.getEmail(), dto.getHp1(), dto.getHp2(), dto.getHp3()};

        int res = jdbcTemplate.update(sql, values);

        return res;
    }

    @Override
    public List<MemberDTO> listMember() {
        String sql = "select * from member";
        List<MemberDTO> list = jdbcTemplate.query(sql, new MyRowMapper());
        if (list.size() == 0) {
            return null;
        } else {
            return list;
        }
    }

    @Override
    public int updateMember(MemberDTO dto) {
            String sql = "update member set passwd=?, "
                    + "email=?, hp1=?, hp2=?, hp3=? where no = ?";
            Object[] values = new Object[]{dto.getEmail(), dto.getHp1(), dto.getHp2(), dto.getHp3(), dto.getNo()};
            int res = jdbcTemplate.update(sql, values);
            return res;
    }

    @Override
    public MemberDTO getMember(int no) {
        String sql = "select * from member where no=?";
        List<MemberDTO> list = jdbcTemplate.query(sql, new MyRowMapper(), no);
        return list.get(0);
    }

    @Override
    public int deleteMember(int no) {
            String sql = "delete from member where no = ?";
            int res = jdbcTemplate.update(sql, no);
            return res;
    }
}
