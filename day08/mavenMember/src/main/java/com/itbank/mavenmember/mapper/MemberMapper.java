package com.itbank.mavenmember.mapper;

import com.itbank.mavenmember.dto.MemberDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

@Service
public class MemberMapper {

    @Autowired
    private SqlSession sqlSession;

    public int insertMember(MemberDTO dto){
        return sqlSession.insert("insertMember", dto);
    }

    public List<MemberDTO> listMember(MemberDTO dto){
        return sqlSession.selectList("listMember", dto);
    }

    public MemberDTO getMember(int no){
        return sqlSession.selectOne("getMember", no);
    }

    public MemberDTO findMember(String search, String searchString){

        Map<String, String> map = new Hashtable<>();
        map.put("search", search);
        map.put("searchString", searchString);

        return sqlSession.selectOne("findMember", map);
    }

    public boolean checkMember(Map<String, String> params){
        MemberDTO dto = sqlSession.selectOne("checkMember", params);
        if(dto == null)
            return false;
        return true;
    }

    public int deleteMember(int no){
        return sqlSession.delete("deleteMember", no);
    }

    public int updateMember(MemberDTO dto){
        return sqlSession.update("updateMember", dto);
    }
}
