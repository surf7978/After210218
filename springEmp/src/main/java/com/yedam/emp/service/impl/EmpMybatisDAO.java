package com.yedam.emp.service.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yedam.emp.EmpVO;

@Repository
public class EmpMybatisDAO {
	@Autowired SqlSessionTemplate sqlSession;
	
	public int insertEmp(EmpVO empVO) {
		return sqlSession.insert("EmpDAO.insertEmp", empVO);
	}
	public int updateEmp(EmpVO empVO) {
		return sqlSession.update("EmpDAO.updateEmp", empVO);
	}
	public int deleteEmp(EmpVO empVO) {
		return sqlSession.delete("EmpDAO.deleteEmp", empVO);
	}
	public EmpVO getEmp(EmpVO empVO) {
		return sqlSession.selectOne("EmpDAO.getEmp", empVO);
	}
	public List<EmpVO> getSearchEmp(EmpVO empVO) {
		return sqlSession.selectList("EmpDAO.getSearchEmp", empVO);
	}
}
