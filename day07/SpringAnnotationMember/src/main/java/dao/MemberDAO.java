package dao;

import dto.MemberDTO;

import java.util.List;

public interface MemberDAO {
    List<MemberDTO> findMember(String search, String searchString);
    int insertMember(MemberDTO dto);
    List<MemberDTO> listMember();
    int updateMember(MemberDTO dto);
    MemberDTO getMember(int no);
    int deleteMember(int no);
    boolean checkMember(String name, String ssn1, String ssn2);

}
