package com.yedam.emp.service;

import java.util.List;

import com.yedam.emp.JobVO;


public interface JobService {
	JobVO getJob(JobVO vo);
	List<JobVO> getSearchJob(JobVO vo);
}
