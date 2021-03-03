package com.yedam.emp.service.impl;

import java.util.List;

import com.yedam.emp.DeptVO;

public interface DeptMapper {
		//등록
		public int insertDept(DeptVO vo);
		//수정
		public int updateDept(DeptVO vo);
		//삭제
		public int deleteDept(DeptVO vo);
		//단건조회
		public DeptVO getDept(DeptVO vo);
		//전체/검색 조회
		public List<DeptVO> getSearchDept(DeptVO vo);
}
