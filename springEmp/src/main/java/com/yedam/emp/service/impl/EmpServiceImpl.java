package com.yedam.emp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.emp.EmpSearchVO;
import com.yedam.emp.EmpVO;
import com.yedam.emp.service.EmpService;

@Service
public class EmpServiceImpl implements EmpService {
	
	//@Autowired EmpSpringDAO dao;
	//@Autowired EmpMybatisDAO dao;
	@Autowired EmpMapper dao;
	
	//@Override
	//@Transactional
	public int insertEmp(EmpVO vo) {
		return dao.insertEmp(vo);
	}

	public int updateEmp(EmpVO vo) {
		return dao.updateEmp(vo);
	}

	public int deleteEmp(EmpVO vo) {
		return dao.deleteEmp(vo);
	}

	public EmpVO getEmp(EmpVO vo) {
		return dao.getEmp(vo);
	}

	public List<EmpVO> getSearchEmp(EmpSearchVO vo) {
		return dao.getSearchEmp(vo);
	}

	public int getCount(EmpSearchVO vo) {
		return dao.getCount(vo);
	}

}
