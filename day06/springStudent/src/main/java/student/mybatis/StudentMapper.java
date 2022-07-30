package student.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import student.DTO.StudentDTO;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class StudentMapper {

    private static SqlSessionFactory sqlMapper;

    static {
        try {
            String resource = "student/mybatis/configuration.xml";
            Reader reader = Resources.getResourceAsReader(resource);
            sqlMapper = new SqlSessionFactoryBuilder().build(reader);
        } catch(IOException e){
            throw new RuntimeException("Something bad happened while building the SqlMapClient instance."+ e, e);
        }
    }

    public static List<StudentDTO> listStudent() {
        SqlSession sqlSession = sqlMapper.openSession();
        try {
            List<StudentDTO> list = sqlSession.selectList("listStudent");
            return list;
        }finally {
            sqlSession.close();
        }
    }

    public static int insertStudent(StudentDTO dto){
        SqlSession sqlSession = sqlMapper.openSession();
        try {
            int res = sqlSession.update("insertStudent", dto);
            sqlSession.commit();
            return res;
        }finally {
            sqlSession.close();
        }
    }

    public static int deleteStudent(String id){
        SqlSession sqlSession = sqlMapper.openSession();
        try {
            int res = sqlSession.update("deleteStudent", id);
            sqlSession.commit();
            return res;
        }finally {
            sqlSession.close();
        }
    }

    public static List<StudentDTO> findStudent(String name){
        SqlSession sqlSession = sqlMapper.openSession();
        try {
            List<StudentDTO> list = sqlSession.selectList("findStudent", name);
            return list;
        }finally {
            sqlSession.close();
        }
    }

}
