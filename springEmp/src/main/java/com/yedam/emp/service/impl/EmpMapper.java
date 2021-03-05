package com.yedam.emp.service.impl;

import java.util.List;

import com.yedam.emp.EmpSearchVO;
import com.yedam.emp.EmpVO;

public interface EmpMapper {
		//등록
		public int insertEmp(EmpVO vo);
		//수정
		public int updateEmp(EmpVO vo);
		//삭제
		public int deleteEmp(EmpVO vo);
		//단건조회
		public EmpVO getEmp(EmpVO vo);
		//전체/검색 조회
		public List<EmpVO> getSearchEmp(EmpSearchVO vo);
		//건수
		public int getCount(EmpSearchVO vo);
}
