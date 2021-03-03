package com.yedam.emp.service.Impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.emp.DeptVO;
import com.yedam.emp.service.DeptService;


@Service //@Service = @Component 상속. bean빈등록, 예외처리
public class DeptServiceImpl implements DeptService {

	@Autowired DeptSpringDAO dao;

	@Override
	public List<DeptVO> getSearchDept(DeptVO vo) {
		return dao.getSearchDept(vo);
	}

	@Override
	public DeptVO getDept(DeptVO vo) {
		return dao.getDept(vo);
	}


	

}
