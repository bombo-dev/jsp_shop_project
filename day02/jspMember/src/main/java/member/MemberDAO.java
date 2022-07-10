package member;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {

    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    private String choice, choiceString;

    public void setChoice(String choice) {
        this.choice = choice;
    }

    public void setChoiceString(String choiceString) {
        this.choiceString = choiceString;
    }

    String url, user, password;


    public MemberDAO(){
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("드라이버 로딩 성공");
        }catch(ClassNotFoundException e){
            System.out.println("oracle 드라이버를 찾지 못하였습니다.");
        }
        url = "jdbc:oracle:thin:@localhost:1521:xe";
        user = "spring07";
        password = "spring07";
    }

    public MemberDTO findMember(MemberDTO input) {
        try {
            String sql = "SELECT * FROM MEMBER WHERE ssn1 = ?, ssn2 = ?";
            conn = DriverManager.getConnection(url, user, password);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, input.getSsn1());
            pstmt.setString(2, input.getSsn2());
            rs = pstmt.executeQuery();

            rs.next();

            MemberDTO row = new MemberDTO();
            row.setEmail(rs.getString("email"));
            row.setHp1(rs.getString("hp1"));
            row.setHp2(rs.getString("hp2"));
            row.setHp3(rs.getString("hp3"));
            row.setJoindate(rs.getString("joindate"));
            row.setName(rs.getString("name"));
            row.setPasswd(rs.getString("passwd"));
            row.setSsn1(rs.getString("ssn1"));
            row.setSsn2(rs.getString("ssn2"));
            row.setNo(rs.getInt("no"));

            return row;

        } catch (SQLException e) {
            System.out.println("findMember 메소드를 실행하지 못하였습니다.");
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e){}
        }
        return null;
    }

    public boolean checkMember(String name, String ssn1, String ssn2) {
        try {
            conn = DriverManager.getConnection(url, user, password);
            String sql = "select * from member where ssn1=? and ssn2=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, ssn1);
            pstmt.setString(2, ssn2);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                return true;
            }else {
                return false;
            }
        }catch(SQLException e) {
            System.out.println("checkMember()실행 중 오류 발생!!");
        }finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            }catch(SQLException e) {}
        }
        return false;
    }

    public int insertMember(MemberDTO input){
        try {
            String sql = "Insert into Member values(member_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate)";
            conn = DriverManager.getConnection(url, user, password);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, input.getName());
            pstmt.setString(2, input.getId());
            pstmt.setString(3, input.getPasswd());
            pstmt.setString(4, input.getSsn1());
            pstmt.setString(5, input.getSsn2());
            pstmt.setString(6, input.getEmail());
            pstmt.setString(7, input.getHp1());
            pstmt.setString(8, input.getHp2());
            pstmt.setString(9, input.getHp3());

            int row = pstmt.executeUpdate();
            return row;
        } catch (SQLException e) {
            System.out.println("insertMember 메소드에서 오류가 발생했습니다." + e.getMessage());
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch(SQLException e){}
        }
        return 0;
    }

    public List<MemberDTO> listMember() {
        List<MemberDTO> list = new ArrayList<>();
        try {
            String sql = "select * from member order by no desc";
            conn = DriverManager.getConnection(url, user, password);
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while(rs.next()){
                MemberDTO member = new MemberDTO();
                member.setNo(rs.getInt("no"));
                member.setId(rs.getString("id"));
                member.setPasswd(rs.getString("passwd"));
                member.setName(rs.getString("name"));
                member.setEmail(rs.getString("email"));
                member.setSsn1(rs.getString("ssn1"));
                member.setSsn2(rs.getString("ssn2"));
                member.setHp1(rs.getString("hp1"));
                member.setHp2(rs.getString("hp2"));
                member.setHp3(rs.getString("hp3"));
                member.setJoindate(rs.getString("joindate"));
                list.add(member);
            }
            return list;
        } catch (SQLException e) {
            System.out.println("listMember method에서 오류가 발생했습니다." +e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch(SQLException e){}
        }
        return null;
    }

    public int deleteMember(int no){
        try {
            conn = DriverManager.getConnection(url, user, password);
            String sql = "delete from member where no = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, no);
            int res = pstmt.executeUpdate();
            return res;
        }catch(SQLException e) {
            System.out.println("deleteMember 메소드 실행시 오류 발생!!");
        }finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            }catch(SQLException e) {}
        }
        return 0;
    }

    public int updateMember(String passwd, String email, String hp1, String hp2, String hp3, int no){
        try {
            String sql = "UPDATE MEMBER SET passwd=?, email=?, hp1=?, hp2=?, hp3=? WHERE no = ?";
            conn = DriverManager.getConnection(url, user, password);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, passwd);
            pstmt.setString(2, email);
            pstmt.setString(3, hp1);
            pstmt.setString(4, hp2);
            pstmt.setString(5, hp3);
            pstmt.setInt(6, no);

            return pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("updateMember 메소드에서 오류가 발생했습니다.");
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch(SQLException e){}
        }
        return 0;
    }

    public MemberDTO getMember(int no){
        try {
            conn = DriverManager.getConnection(url, user, password);
            String sql = "select * from member where no=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, no);
            rs = pstmt.executeQuery();
            List<MemberDTO> list = makeList(rs);
            return list.get(0);
        }catch(SQLException e) {
            System.out.println("getMember()실행 중 오류 발생!!");
        }finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            }catch(SQLException e) {}
        }
        return null;
    }

    protected List<MemberDTO> makeList(ResultSet rs) throws SQLException{
        List<MemberDTO> list = new ArrayList<>();
        while(rs.next()) {
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
            list.add(dto);
        }
        return list;
    }

    public MemberDTO selectOneMember(){
        try {
            conn = DriverManager.getConnection(url, user, password);
                String sql = "select * from member where " + choice +"=?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, choiceString);
                rs = pstmt.executeQuery();
                List<MemberDTO> list = makeList(rs);
                return list.get(0);
        }catch(SQLException e) {
            System.out.println("getMember()실행 중 오류 발생!!");
        }finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            }catch(SQLException e) {}
        }
        return null;
    }

}
