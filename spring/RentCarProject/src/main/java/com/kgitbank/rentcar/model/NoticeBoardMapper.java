package com.kgitbank.rentcar.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kgitbank.rentcar.dto.NoticeBoardDTO;

@Service
public class NoticeBoardMapper {

	@Autowired
	private SqlSession sqlSession;
	
	public List<NoticeBoardDTO> listBoard() {
		return sqlSession.selectList("listBoard");
	}
	
	public int insertBoard(NoticeBoardDTO dto) {
		return sqlSession.insert("insertBoard", dto);
	}
	
	public NoticeBoardDTO getBoard(int num, String mode) {
		if (mode.equals("content")) {
			sqlSession.update("plusReadcount", num);
		}
		return sqlSession.selectOne("getBoard", num);
	}
}
