package com.itbank.mavenboard.mapper;

import com.itbank.mavenboard.dto.BoardDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardMapper {

	@Autowired
	private SqlSession sqlSession;

	public List<BoardDTO> listBoard() {
		return sqlSession.selectList("listBoard");
	}

	public BoardDTO getBoard(int num, String content){
		if(content.equals("content")){
			sqlSession.update("plusReadcount", num);
		}
		return sqlSession.selectOne("getBoard", num);
	}

	public int insertBoard(BoardDTO dto){
		return sqlSession.insert("insertBoard", dto);
	}

	public int deleteBoard(int num) {
		return sqlSession.delete("deleteBoard", num);
	}

	public int updateBoard(BoardDTO dto) {
		return sqlSession.update("updateBoard", dto);
	}

}










