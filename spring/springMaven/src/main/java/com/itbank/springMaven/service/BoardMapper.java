package com.itbank.springMaven.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.springMaven.dto.BoardDTO;

@Service
public class BoardMapper {

	@Autowired
	private SqlSession sqlSession;
	
	public List<BoardDTO> listBoard(){
		return sqlSession.selectList("listBoard");
	}
	
	public BoardDTO getBoard(int num, String mode) {
		if (mode.equals("content")) {
			sqlSession.update("plusReadcount", num);
		}
		return sqlSession.selectOne("getBoard", num);
	}
	
	public int insertBoard(BoardDTO dto) {
		return sqlSession.insert("insertBoard", dto);
	}
	
	public int deleteBoard(int num, String passwd) {
		BoardDTO dto = getBoard(num, "password");
		if (dto.getPasswd().equals(passwd)) {
			return sqlSession.delete("deleteBoard", num);
		}else {
			return -1;
		}
	}
	
	public int updateBoard(BoardDTO dto) {
		BoardDTO dto2 = getBoard(dto.getNum(), "password");
		if (dto2.getPasswd().equals(dto.getPasswd())) {
			return sqlSession.update("updateBoard", dto);
		}else {
			return -1;
		}
	}
}














