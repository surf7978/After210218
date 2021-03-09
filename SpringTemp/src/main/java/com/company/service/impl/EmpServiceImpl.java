package com.company.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.service.EmpService;
import com.company.temp.EmpVO;

@Service
public class EmpServiceImpl implements EmpService {
	
	@Autowired EmpMapper dao;
	
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

	@Override
	public List<EmpVO> getSearchEmp(EmpVO vo) {
		return dao.getSearchEmp(vo);
	}

}
