package com.company.yedam.emp.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.yedam.emp.dao.DeptDAO;
import com.company.yedam.emp.dao.DeptVO;
import com.company.yedam.emp.service.DeptService;

@Service //@Service = @Component 상속. bean빈등록, 예외처리
public class DeptServiceImpl implements DeptService {

	@Autowired DeptDAO deptDAO;

	@Override
	public ArrayList<DeptVO> deptList() {
		return deptDAO.selectList();
	}
	

}
