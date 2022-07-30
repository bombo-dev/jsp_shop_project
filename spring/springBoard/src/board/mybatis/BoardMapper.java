package board.mybatis;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import board.dto.BoardDTO;

public class BoardMapper {
private static SqlSessionFactory sqlMapper;
	
	static {
		try {
			String resource = "board/mybatis/configuration.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			sqlMapper = new SqlSessionFactoryBuilder().build(reader);
		}catch(IOException e) {
			throw new RuntimeException("Something bad happened while "
											+ "building the SqlMapClient instance." + e, e);
		}
	}
	
	public static List<BoardDTO> listBoard(){
		SqlSession sqlSession = sqlMapper.openSession();
		try {
			List<BoardDTO> list = BoardMapper.listBoard();
			return list;
		}finally {
			sqlSession.close();
		}
	}
	
	public static BoardDTO getBoard(int num, String mode){
		SqlSession sqlSession = sqlMapper.openSession();
		try {
			if (mode.equals("content")) {
				sqlSession.update("plusReadcount", num);
				sqlSession.commit();
			}
			BoardDTO dto = sqlSession.selectOne("getBoard", num);
			return dto;
		}finally {
			sqlSession.close();
		}
	}
	
	public static int insertBoard(BoardDTO dto) {
		SqlSession sqlSession = sqlMapper.openSession();
		try {
			int res = sqlSession.insert("insertBoard", dto);
			sqlSession.commit();
			return res;
		}finally {
			sqlSession.close();
		}
	}
	
	public static int deleteBoard(int num) {
		SqlSession sqlSession = sqlMapper.openSession();
		try {
			int res = sqlSession.delete("deleteBoard", num);
			sqlSession.commit();
			return res;
		}finally {
			sqlSession.close();
		}
	}
	
	public static int updateBoard(BoardDTO dto) {
		SqlSession sqlSession = sqlMapper.openSession();
		try {
			BoardDTO dto2 = getBoard(dto.getNum(), "password");
			if (dto2.getPasswd().equals(dto.getPasswd())) {
				int res = sqlSession.update("updateBoard", dto);
				sqlSession.commit();
				return res;
			}else {
				return -1;
			}
		}finally {
			sqlSession.close();
		}
	}
}










