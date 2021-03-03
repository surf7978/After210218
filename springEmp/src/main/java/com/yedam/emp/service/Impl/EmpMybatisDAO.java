package com.yedam.emp.service.Impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yedam.emp.EmpVO;

@Repository
public class EmpMybatisDAO {
	@Autowired SqlSessionTemplate sqlSession;
	
	public int insertEmp(EmpVO empVO) {
		return 0;
	}
	public int updateEmp(EmpVO empVO) {
		return 0;
	}
	public int deleteEmp(EmpVO empVO) {
		return 0;
	}
	public EmpVO getEmp(EmpVO empVO) {
		return null;
	}
	public List<EmpVO> getSearchEmp(EmpVO empVO) {
		System.out.println("mybatis 실행테스트");
		return sqlSession.selectList("EmpDAO.getSearchEmp", empVO);
	}
}
