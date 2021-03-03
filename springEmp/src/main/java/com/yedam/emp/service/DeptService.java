package com.yedam.emp.service;

import java.util.List;
import com.yedam.emp.DeptVO;

public interface DeptService {
	DeptVO getDept(DeptVO vo);
	List<DeptVO> getSearchDept(DeptVO vo);
}
