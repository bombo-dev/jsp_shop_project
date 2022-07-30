package board.resource;

import board.DTO.BoardDTO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class BoardMapper {

    private static SqlSessionFactory sqlMapper;

    static {
        try {
            String resource = "board/resource/configuration.xml";
            Reader reader = Resources.getResourceAsReader(resource);
            sqlMapper = new SqlSessionFactoryBuilder().build(reader);
        } catch(IOException e){
            throw new RuntimeException("Something bad happened while building the SqlMapClient instance."+ e, e);
        }
    }

    public static List<BoardDTO> listBoard() {
        SqlSession sqlSession = sqlMapper.openSession();
        try {
            List<BoardDTO> list = sqlSession.selectList("listBoard");
            return list;
        } finally {
            sqlSession.close();
        }
    }

    public static int insertBoard(BoardDTO dto){
        SqlSession sqlSession = sqlMapper.openSession();
        try {
            int res = sqlSession.update("insertBoard", dto);
            sqlSession.commit();
            return res;
        }finally {
            sqlSession.close();
        }
    }

    public static List<BoardDTO> getBoard(int num){
        SqlSession sqlSession = sqlMapper.openSession();
        try {
            List<BoardDTO> list = sqlSession.selectList("getBoard", num);
            return list;
        }finally {
            sqlSession.close();
        }
    }

    public static int deleteBoard(int num){
        SqlSession sqlSession = sqlMapper.openSession();
        try {
            int res = sqlSession.update("deleteBoard", num);
            sqlSession.commit();
            return res;
        } finally {
            sqlSession.close();
        }
    }

    public static int updateBoard(BoardDTO dto){
        SqlSession sqlSession = sqlMapper.openSession();
        try {
            int res = sqlSession.update("updateBoard", dto);
            sqlSession.commit();
            return res;
        } finally {
            sqlSession.close();
        }
    }
}
