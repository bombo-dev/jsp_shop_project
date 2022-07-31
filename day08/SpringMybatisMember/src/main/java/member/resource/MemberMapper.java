package member.resource;

import member.dto.MemberDTO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Map;

public class MemberMapper {

    private static SqlSessionFactory sqlMapper;

    static {
        try {
            String resource = "member/resource/configuration.xml";
            Reader reader = Resources.getResourceAsReader(resource);
            sqlMapper = new SqlSessionFactoryBuilder().build(reader);
        }catch(IOException e) {
            throw new RuntimeException("Something bad happened while "
                    + "building the SqlMapClient instance." + e, e);
        }
    }

    public static int insertMember(MemberDTO dto) {
        SqlSession sqlSession = sqlMapper.openSession();

        try {
            int res = sqlSession.insert("insertMember", dto);
            sqlSession.commit();
            return res;
        } finally {
            sqlSession.close();
        }
    }

    public static List<MemberDTO> listMember(){
        SqlSession sqlSession = sqlMapper.openSession();

        try{
            List<MemberDTO> list = sqlSession.selectList("listMember");
            return list;
        } finally {
            sqlSession.close();
        }
    }

    public static MemberDTO getMember(int no) {

        SqlSession sqlSession = sqlMapper.openSession();

        try{
            MemberDTO dto = sqlSession.selectOne("getMember", no);
            return dto;
        } finally {
            sqlSession.close();
        }

    }

    public static MemberDTO getMemberId(String id) {
        SqlSession sqlSession = sqlMapper.openSession();

        try{
            MemberDTO dto = sqlSession.selectOne("getMemberId", id);
            return dto;
        } finally {
            sqlSession.close();
        }
    }

    public static boolean checkMember(Map<String, Object> map){
        SqlSession sqlSession = sqlMapper.openSession();

        try{
            Object isMember = sqlSession.selectOne("checkMember", map);
            if(isMember == null){
                return false;
            } else{
                return true;
            }
        } finally {
            sqlSession.close();
        }

    }

    public static int deleteMember(int no){
        SqlSession sqlSession = sqlMapper.openSession();

        try{
            int res = sqlSession.delete("deleteMember", no);
            sqlSession.commit();
            return res;
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

    public static int checkLogin(String id){
        SqlSession sqlSession = sqlMapper.openSession();

        try {
            String dbPass = sqlSession.selectOne("checkLogin", id);
            if(dbPass == null){
                return -1;
            } else {
                return Integer.parseInt(dbPass);
            }
        } finally {
            sqlSession.close();
        }
    }



}
