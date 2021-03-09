package com.company.service.impl;

import java.util.List;

import com.company.temp.EmpVO;

public interface EmpMapper {
		//등록
		public int insertEmp(EmpVO vo);
		//수정
		public int updateEmp(EmpVO vo);
		//삭제
		public int deleteEmp(EmpVO vo);
		//단건조회
		public EmpVO getEmp(EmpVO vo);
		
		public List<EmpVO> getSearchEmp(EmpVO vo);
}
