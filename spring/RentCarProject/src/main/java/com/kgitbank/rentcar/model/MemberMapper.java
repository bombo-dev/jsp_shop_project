package com.kgitbank.rentcar.model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kgitbank.rentcar.dto.MemberDTO;

@Service
public class MemberMapper {
	
	@Autowired
	private SqlSession sqlSession;
	
	public boolean checkMember(Map<String, String> params) {
		MemberDTO dto = sqlSession.selectOne("checkMember", params);
			if (dto == null) return false;
			return true;
	}
		
	public int insertMember(MemberDTO dto) {
		return sqlSession.insert("insertMember", dto);
	}
	
	public String searchMember(Map<String, String> params) {
		String msg = null;
		if (params.containsKey("id")) {
			MemberDTO dto = sqlSession.selectOne("searchPw", params);
			if (dto != null) {
				msg = dto.getPasswd();
			}else {
				msg = "�ش������� ��ġ���� �ʽ��ϴ�.";
			}
		}else {
			MemberDTO dto = sqlSession.selectOne("searchId", params);
			if (dto != null) {
				msg = dto.getId();
			}else {
				msg = "���̵� �������� �ʽ��ϴ�.";
			}
		}
		return msg;
	}
	
	public MemberDTO LoginOk(String id) {
		return sqlSession.selectOne("loginOk", id);
	}
	
	public List<MemberDTO> listMember() {
		return sqlSession.selectList("listMember");
	}
	
	public List<MemberDTO> findMember(String search, String searchString) {
		java.util.Map<String, String> map = new java.util.Hashtable<>();
		map.put("search", search);
		map.put("searchString", searchString);
		return sqlSession.selectList("findMember", map);
	}
	
	public int deleteMember(int no) {
		return sqlSession.delete("deleteMember", no);
	}
	
	public MemberDTO getMember(int no) {
		return sqlSession.selectOne("getMember", no);
	}
	
	public int updateMember(MemberDTO dto) {
		return sqlSession.update("updateMember", dto);
	}
}






