package member.mybatis;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import member.dto.MemberDTO;

public class MemberMapper {
	private static SqlSessionFactory sqlMapper;
	
	static {
		try {
			String resource = "member/mybatis/configuration.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			sqlMapper = new SqlSessionFactoryBuilder().build(reader);
		}catch(IOException e) {
			throw new RuntimeException("Something bad happened while "
											+ "building the SqlMapClient instance." + e, e);
		}
	}
	
	public static boolean checkMember(Map<String, String> params) {
		SqlSession sqlSession = sqlMapper.openSession();
		try {
			MemberDTO dto = sqlSession.selectOne("checkMember", params);
			if (dto == null) return false;
			return true;
		}finally {
			sqlSession.close();
		}
	}
	
	public static int insertMember(MemberDTO dto) {
		SqlSession sqlSession = sqlMapper.openSession();
		try {
			int res = sqlSession.insert("insertMember", dto);
			sqlSession.commit();
			return res;
		}finally {
			sqlSession.close();
		}
	}
	
	public static List<MemberDTO> listMember() {
		SqlSession sqlSession = sqlMapper.openSession();
		try {
			List<MemberDTO> list = sqlSession.selectList("listMember");
			return list;
		}finally {
			sqlSession.close();
		}
	}
	
	public static List<MemberDTO> findMember(String search, String searchString) {
		SqlSession sqlSession = sqlMapper.openSession();
		java.util.Map<String, String> map = new java.util.Hashtable<>();
		map.put("search", search);
		map.put("searchString", searchString);
		try {
			List<MemberDTO> list = sqlSession.selectList("findMember", map);
			return list;
		}finally {
			sqlSession.close();
		}
	}
	
	public static int deleteMember(int no) {
		SqlSession sqlSession = sqlMapper.openSession();
		try {
			int res = sqlSession.delete("deleteMember", no);
			sqlSession.commit();
			return res;
		}finally {
			sqlSession.close();
		}
	}
	
	public static MemberDTO getMember(int no) {
		SqlSession sqlSession = sqlMapper.openSession();
		try {
			MemberDTO list = sqlSession.selectOne("getMember", no);
			return list;
		}finally {
			sqlSession.close();
		}
	}
	
	public static int updateMember(MemberDTO dto) {
		SqlSession sqlSession = sqlMapper.openSession();
		try {
			int res = sqlSession.update("updateMember", dto);
			sqlSession.commit();
			return res;
		}finally {
			sqlSession.close();
		}
	}
}






