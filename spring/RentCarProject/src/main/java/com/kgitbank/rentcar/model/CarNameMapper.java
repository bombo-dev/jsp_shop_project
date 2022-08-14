package com.kgitbank.rentcar.model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kgitbank.rentcar.dto.CarNameDTO;

@Service
public class CarNameMapper {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<CarNameDTO> listCarName(){
		return sqlSession.selectList("listCarName");
	}
	
	public CarNameDTO getCarName(int num){
		return sqlSession.selectOne("getCarName", num);
	}
	
	public int insertCarName(CarNameDTO dto) {
		return sqlSession.insert("insertCarName", dto);
	}
	
	public int deleteCarName(int num) {
		return sqlSession.delete("deleteCarName", num);
	}
	
	public int updateCarName(Map<String, String> map) {
		return sqlSession.update("updateCarName", map);
	}
}
