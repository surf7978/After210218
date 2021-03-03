package com.yedam.emp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.emp.JobVO;
import com.yedam.emp.service.JobService;


@Service //@Service = @Component 상속. bean빈등록, 예외처리
public class JobServiceImpl implements JobService {

	@Autowired JobSpringDAO dao;

	@Override
	public List<JobVO> getSearchJob(JobVO vo) {
		return dao.getSearchJob(vo);
	}

	@Override
	public JobVO getJob(JobVO vo) {
		return dao.getJob(vo);
	}

	

}
