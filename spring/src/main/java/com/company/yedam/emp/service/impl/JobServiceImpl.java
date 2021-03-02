package com.company.yedam.emp.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.yedam.emp.dao.JobDAO;
import com.company.yedam.emp.dao.JobVO;
import com.company.yedam.emp.service.JobService;

@Service //@Service = @Component 상속. bean빈등록, 예외처리
public class JobServiceImpl implements JobService {

	@Autowired JobDAO jobDAO;

	@Override
	public ArrayList<JobVO> jobList() {
		return jobDAO.selectList();
	}
	

}
