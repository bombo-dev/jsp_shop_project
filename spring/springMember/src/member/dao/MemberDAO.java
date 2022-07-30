package member.dao;

import java.util.List;

import member.dto.MemberDTO;

public interface MemberDAO {
	public boolean checkMember(String name, String ssn1, String ssn2);
	public int insertMember(MemberDTO dto);
	public int deleteMember(int no);
	public int updateMember(MemberDTO dto);
	public MemberDTO getMember(int no);
	public List<MemberDTO> listMember();
	public List<MemberDTO> findMember(String search, String searchString);
}
