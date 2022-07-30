package dao;

import dto.MemberDTO;

import java.util.List;

public interface MemberDAO {
    List<MemberDTO> findMember(MemberDTO dto);
    int insertMember(MemberDTO dto);
    List<MemberDTO> listMember();
    int updateMember(MemberDTO dto);
    MemberDTO getMember(int no);
    int deleteMember(int no);

}
